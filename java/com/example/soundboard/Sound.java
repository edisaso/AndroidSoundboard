package com.example.soundboard;

public class Sound {
    private String name;
    private int soundResource;

    public Sound(String name, int soundResource) {
        this.name = name;
        this.soundResource = soundResource;
    }

    public String getName() {
        return name;
    }

    public int getSoundResource() {
        return soundResource;
    }
}

