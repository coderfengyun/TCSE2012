package week10;

import java.util.ArrayList;
import java.util.List;

public class TextJustify {
	public List<String> fullJustify(String[] words, int L) {
		if (words == null)
			return null;
		if (words.length == 0) {
			return new ArrayList<String>();
		}
		List<String> sentences = new ArrayList<String>();
		for (int i = 0, lineWidth = 0, lineStart = 0; i < words.length; i++) {
			if (lineWidth + words[i].length() + 1 <= L + 1) {
				lineWidth = lineWidth + words[i].length() + 1;
				if (i == words.length - 1) {
					StringBuilder builder = new StringBuilder();
					for (int j = lineStart; j <= i; j++) {
						if (j != lineStart) {
							builder.append(' ');
						}
						builder.append(words[j]);
					}
					int currentLen = builder.length();
					for (int k = 0; k < L - currentLen; k++) {
						builder.append(' ');
					}
					sentences.add(builder.toString());
				}
			} else {
				StringBuilder builder = new StringBuilder();
				int wordCnt = i - lineStart;
				int spaceCnt = L - (lineWidth - wordCnt);
				if (wordCnt == 1) {
					builder.append(words[lineStart]);
					for (int k = 0; k < L - words[lineStart].length(); k++) {
						builder.append(' ');
					}
				} else {
					int evenlyCnt = spaceCnt / (wordCnt - 1);
					int remainedCnt = spaceCnt % (wordCnt - 1);

					for (int j = lineStart; j < i; j++) {
						if (j != lineStart) {
							for (int k = 0; k < evenlyCnt; k++) {
								builder.append(' ');
							}
							if (j <= lineStart + remainedCnt) {
								builder.append(' ');
							}
						}
						builder.append(words[j]);
					}
				}
				sentences.add(builder.toString());
				lineStart = i;
				lineWidth = 0;
				i--;
			}
		}
		return sentences;
	}

	public static void main(String[] args) {
		TextJustify s = new TextJustify();
		List<String> sentences = s.fullJustify(new String[] { "a","b","c","d","e" }, 16);
		for (String sentence : sentences) {
			System.out.println(sentence);
		}
	}
}
