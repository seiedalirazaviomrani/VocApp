package com.razavy.vocapp;

public class Vocabulary {
    private String mVocabulary;
    private String mSampleSentence;

    public Vocabulary(String vocabulary, String sampleSentence) {
        this.mVocabulary = vocabulary;
        this.mSampleSentence = sampleSentence;
    }

    public String getVocabulary() {
        return this.mVocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.mVocabulary = vocabulary;
    }

    public String getSampleSentence() {
        return this.mSampleSentence;
    }

    public void setSampleSentence(String sampleSentence) {
        this.mSampleSentence = sampleSentence;
    }
}
