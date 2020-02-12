package com.bendaten.trainer.chapter12;

import java.io.*;
import java.util.Properties;

public class PropsHandler {
    private Properties p;

    public PropsHandler() {
        this.p = new Properties();
    }

    public void add(String key, String value) {
        p.setProperty(key, value);
    }

    public void store(String path) throws IOException {
        try (OutputStream os = new FileOutputStream(path)) {
            this.p.store(os, null);
        }
    }

    public void retrieve(String path) throws IOException {
        try (InputStream is = new FileInputStream(path)) {
            this.p.load(is);
        }
    }

    public boolean hasKey(String key) {
        return p.containsKey(key);
    }

    public String get(String key) {
        return p.getProperty(key);
    }
}
