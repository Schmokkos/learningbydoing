package no.schweizer.lists;

public class WordList {

    public String[] listOfWords(int length){
        if (length == 5){
            return new String[]{"patch","white","bench","ghost","trace","wheel","money","right","basin","tired"};
        }
        else if (length == 6){
            return new String[]{"string","outfit","polish","social","forget","gravel","vacuum","dealer","sample"};
        }
        else if (length == 7){
            return new String[]{"content","athlete","balance","mention","funeral","mention","purpose","pioneer","extinct","concern"};
        }
        else throw new IllegalArgumentException("Cannot generate word with length: "+length);
    }
}
