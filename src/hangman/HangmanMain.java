package hangman;

import java.util.Scanner;

public class HangmanMain {
	public static void main(String[] args) {

		//1. 단어 배열
		String[] words = {"java", "count", "school", "book", "student", "programmer"};
		
		//2. 랜덤 선정
		int answerIndex = (int)(Math.random()*6);
		StringBuffer quiz = new StringBuffer(words[answerIndex]);
		
		//3.빈 단어 개수만큼 '_' 밑줄 생성하고 콘솔에 출력
		StringBuffer quizShow = new StringBuffer(words[answerIndex]);
		for(int i=0; i<words[answerIndex].length(); i++) {
			quizShow.setCharAt(i, '_');
		}
		
		while(true) {
			System.out.println("현재 상태 : "+quizShow);
			System.out.print("글자를 추측하세요 : ");
			
			//4. Scanner로 알파벳 입력받기
			String input = new Scanner(System.in).next();
			
			//5. 단어 안에 있는지 확인하기
			//6. 해당 index number에 알파벳 삽입
			int quizIndex = quiz.indexOf(input);
			if(quizIndex != -1) {
				quizLoop : while(true) {
					quiz.replace(quizIndex, quizIndex+1, "_");
					quizShow.replace(quizIndex, quizIndex+1, input);
					quizIndex = quiz.indexOf(input);
					if(quizIndex == -1) {
						break quizLoop;
					}
				}
			}
			if(words[answerIndex].indexOf(input) == 0 && input.length() == words[answerIndex].length()) {
				System.out.println("현재 상태 : "+words[answerIndex]);
				System.out.println("정답입니다!");
				break;
			}
			
			if(quizShow.indexOf("_") == -1) {
				System.out.println("현재 상태 : "+quizShow);
				System.out.println("정답입니다!");
				break;
			}
		}
		
	}
}
