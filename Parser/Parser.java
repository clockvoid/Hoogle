import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Parser {
	
	private String answerPatternString = "<div class=\'ans\'>(.*)</div>";
	private String fromPatternString = "<div class=\'from\'>(.*)</div>";
	private Pattern answerPattern;
	private Pattern fromPattern;

	public Parser() {
		answerPattern = Pattern.compile(answerPatternString);
		fromPattern = Pattern.compile(fromPatternString);
	}

	public String parse(String arg) {
		String data = "";
		for (String index : arg.split("\n", 0)) {
			Matcher answerMatcher = answerPattern.matcher(index);
			Matcher fromMatcher = fromPattern.matcher(index);
			if (answerMatcher.find()) {
				data += (" " + index.replaceAll("<.+?>", "")).replaceAll("\n", "");
				data += "\n";
			} else if (fromMatcher.find()) {
				data += ("  " + index.replaceAll("<.+?>", "")).replaceAll("\n", "");
				data += "\n\n";
			}
		}
		return data;
	}
}
