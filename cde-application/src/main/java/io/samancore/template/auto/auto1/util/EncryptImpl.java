package io.samancore.template.auto.auto1.util;

import java.util.Base64;

import io.samancore.common.transformer.Encrypt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.kms.model.DecryptResponse;
import software.amazon.awssdk.services.kms.model.EncryptionAlgorithmSpec;

@ApplicationScoped
public class EncryptImpl implements Encrypt {

    @Inject
    KmsClient kms;

    @ConfigProperty(name = "kms.key.arn")
    String keyArn;

    @Override
    public byte[] encrypt(String data) {
        SdkBytes encryptedBytes = kms.encrypt(req ->
                req
                        .keyId(keyArn)
                        .encryptionAlgorithm(EncryptionAlgorithmSpec.RSAES_OAEP_SHA_1)
                        .plaintext(SdkBytes.fromUtf8String(data))
        ).ciphertextBlob();

        return Base64.getEncoder().encode(encryptedBytes.asByteArray());
    }

    @Override
    public String decrypt(byte[] data) {
        SdkBytes encryptedData = SdkBytes.fromByteArray(Base64.getDecoder().decode(data));
        DecryptResponse decrypted = kms.decrypt(req ->
                req
                        .keyId(keyArn)
                        .encryptionAlgorithm(EncryptionAlgorithmSpec.RSAES_OAEP_SHA_1)
                        .ciphertextBlob(encryptedData)
        );

        return decrypted.plaintext().asUtf8String();
    }
}
