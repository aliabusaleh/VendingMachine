package com.example.vendingmachine.models.payment.notes;

/*
 * this enum  class used for the Notes inserted in the note slot,
 * it also contains the constructor for the notes
 */

public enum NotesValues {
    TWENTY_DOLLER(200.00), FIFTY_DOLLER(500.00);

    private final double value;

    NotesValues(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}