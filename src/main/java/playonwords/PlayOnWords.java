package playonwords;

import java.util.List;
import java.util.Stack;

public class PlayOnWords {

    private Stack<Integer> currentChain;
    private List<String> words;

    public PlayOnWords(List<String> words) {
        this.words = words;
        currentChain = new Stack<>();
    }

    public boolean isOrderingPossible() {
        boolean isOrderingPossible = false;
        if (words.size() == 1) {
            if (canWordFollowWordInChain(words.get(0), words.get(0))) {
                isOrderingPossible = true;
            }
        } else {
            int i = 0;
            while (!isOrderingPossible && i < words.size()) {
                if (currentChain.isEmpty() || (!currentChain.contains(i) && canWordFollowWordInChain(words.get(currentChain.peek()), words.get(i)))) {
                    currentChain.push(i);
                    if (currentChain.size() == words.size() || isOrderingPossible()) {
                        isOrderingPossible = true;
                    } else {
                        currentChain.pop();
                    }
                }
                i++;
            }
        }
        return isOrderingPossible;
    }

    private boolean canWordFollowWordInChain(String word, String nextWord) {
        boolean result = false;
        if (word.charAt(word.length() - 1) == nextWord.charAt(0)) {
            result = true;
        }
        return result;
    }

}
