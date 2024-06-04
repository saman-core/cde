package io.samancore.template.auto.auto1.util;

import io.quarkus.arc.DefaultBean;
import io.samancore.common.transformer.Encrypt;
import jakarta.enterprise.context.ApplicationScoped;

import java.nio.charset.StandardCharsets;

@ApplicationScoped
@DefaultBean
public class EncryptLocalImpl implements Encrypt {

    @Override
    public byte[] encrypt(String o) {
        return o.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String decrypt(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
