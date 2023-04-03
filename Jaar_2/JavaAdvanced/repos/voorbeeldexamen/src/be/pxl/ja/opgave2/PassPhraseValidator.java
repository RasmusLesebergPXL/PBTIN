package be.pxl.ja.opgave2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PassPhraseValidator<O> extends Thread {
    private List<O> passPhrase;

    public PassPhraseValidator(List<O> passPhrase) {
        this.passPhrase = passPhrase;
    }

    public List<O> getPassPhrase() {
        return passPhrase;
    }

    @Override
    public void run() {

    }

    public boolean isValid() {
        Set<O> set = new HashSet<>(passPhrase);
        return set.size() == passPhrase.size();
    }
}
