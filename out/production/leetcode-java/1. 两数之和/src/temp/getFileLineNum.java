package temp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getFileLineNum {
	public static void main(String[] args) {

		int num = 0;
		int letter = 0;
		int line = 0;
		int space = 0;
		int word = 0;
		try {
			File file = new File("D:\\text.txt");
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String string = null;
			while ((string = bufferedReader.readLine()) != null) {
				line++;
				num += countNumber(string);
				letter += countLetter(string);
				word += countChinese(string);
				space += countSpace(string);

			}
			bufferedReader.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("��������" + num);
		System.out.println("��ĸ��" + letter);
		System.out.println("������" + word);
		System.out.println("�ո���" + space);
		System.out.println("����" + line);

	}

	public static int countNumber(String str) {
		int count = 0;
		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher(str);
		while (m.find()) {
			count++;
		}
		return count;
	}

	public static int countLetter(String str) {
		int count = 0;
		Pattern p = Pattern.compile("[a-zA-Z]");
		Matcher m = p.matcher(str);
		while (m.find()) {
			count++;
		}
		return count;
	}

	public static int countChinese(String str) {
		int count = 0;
		Pattern p = Pattern.compile("[\\u4E00-\\u9FA5]");
		Matcher m = p.matcher(str);
		while (m.find()) {
			count++;
		}
		return count;
	}

	public static int countSpace(String str) {
		int count = 0;
		Pattern p = Pattern.compile("\\s");
		Matcher m = p.matcher(str);
		while (m.find()) {
			count++;
		}
		return count;
	}

	public void test() {
		int count = 0;
		try {
			File file = new File("D:\\text.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				scanner.nextLine();
				count++;
			}
			System.out.println(count);
			scanner.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}
}
