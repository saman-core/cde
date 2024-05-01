package io.samancore.template.auto.auto1.util;

import io.samancore.common.transformer.Masker;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MaskerImpl implements Masker {
    @Override
    public String apply(Object s) {
        return s.toString();
    }
}
