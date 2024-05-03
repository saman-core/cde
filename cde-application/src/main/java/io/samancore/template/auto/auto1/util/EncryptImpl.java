package io.samancore.template.auto.auto1.util;

import io.samancore.common.transformer.Encrypt;
import jakarta.enterprise.context.ApplicationScoped;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@ApplicationScoped
public class EncryptImpl implements Encrypt {

    private final static Charset charset = StandardCharsets.UTF_8;

    @Override
    public byte[] encrypt(Object o) {
        return charset.encode((String)o).array();
    }

    @Override
    public String decrypt(byte[] o) {
        return charset.decode(ByteBuffer.wrap(o)).toString();
    }
}
