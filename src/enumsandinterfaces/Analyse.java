package enumsandinterfaces;

public class Analyse {
    public class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
        private String[] keywords;

        SpamAnalyzer(String[] keywords) {
            this.keywords = keywords;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }

        @Override
        public Label processText(String my_text) {
            String[] words_spam = getKeywords();
            for (String key_i : words_spam) {
                boolean check = my_text.contains(key_i);
                if (check) return getLabel();
            }
            return Label.OK;

        }
    }

    public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
        private String[] keywords_negative = {":(", ":|", "=("};

        @Override
        protected String[] getKeywords() {
            return keywords_negative;
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }

        @Override
        public Label processText(String my_text) {
            String[] words_negative = getKeywords();
            for (String key_i : words_negative) {
                boolean check = my_text.contains(key_i);
                if (check) return getLabel();
            }
            return Label.OK;
        }
    }

    public class TooLongTextAnalyzer {
        private String[] keywords;

        private int maxLength;

        TooLongTextAnalyzer(int maxLength) {
            this.maxLength = maxLength;
        }

        public Label processText(String text) {
            if (text.length() > maxLength) return Label.TOO_LONG;
            return Label.OK;
        }
    }

    public abstract class KeywordAnalyzer {

        abstract String[] getKeywords();

        abstract Label getLabel();
    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer obj_txt_an : analyzers) {
            Label label_check = obj_txt_an.processText(text);
            if (label_check != Label.OK) return label_check;
        }
        return Label.OK;
    }
}
