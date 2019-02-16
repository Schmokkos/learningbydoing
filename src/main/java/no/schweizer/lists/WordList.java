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

    public String[] listOfSentances(){
        return new String[]{"The quick brown fox jumps over the lazy dog","Everyone was busy so I went to the movie alone","Love means never having to say you are sorry","They may take our lives, but they will never take our freedom","Get your stinking paws off me you damned dirty ape","You make me want to be a better man","They call it a Royale with cheese","Magic Mirror on the wall who is the fairest one of all","Just when I thought I was out, they pull me back in","Pay no attention to that man behind the curtain","Keep your friends close but your enemies closer","I love the smell of napalm in the morning"};
    }
}
