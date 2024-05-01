package io.samancore.template.auto.auto1.util;

import io.samancore.common.transformer.Encrypt;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EncryptImpl implements Encrypt {
    @Override
    public Object encrypt(Object o) {
        return o;
    }

    @Override
    public Object decrypt(Object o) {
        return o;
    }
}
