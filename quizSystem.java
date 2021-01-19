import java.util.*;
class quiz{
	private List<String> question = new ArrayList<String>(); 
	private List<String> answer = new ArrayList<String>(); 
	private List<Integer> numberOfAnswer = new ArrayList<Integer>();
	private List<Integer> numberOfCorrectAnswer = new ArrayList<Integer>();
	private List<Integer> indexOfCorrectAnswer = new ArrayList<Integer>();
	private List<Integer> score = new ArrayList<Integer>();
	public void addQuestion(){
		String Question;
		int choice;
		String ch;
		int i= 0,count = 0;
		String Answer="";
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter your question: ");
		Question = sc.nextLine();
		question.add(Question);
		System.out.print("\nAdding the multiple choices answers \nPress[1] Add two answers\nPress[2] Add three answers\nPress[3] Add four answers\n*Note: You need to add at least one correct");
		System.out.print("\nEnter your choice: ");
		choice = sc.nextInt();
		if((choice == 1) || (choice == 2) || (choice == 2)){
			choice = choice + 1;
			numberOfAnswer.add(choice);
			while(i<choice){
				System.out.print("It is the right answer? Y/N : ");
				if(i == 0){
					ch = sc.nextLine();
				}
				ch = sc.nextLine();
				System.out.print("\nyour answer: ");
				Answer = sc.nextLine();
				if((ch.equals("Y")) || (ch.equals("y")) || (ch.equals("yes"))){
					indexOfCorrectAnswer.add(i+1);
					count ++;
				}
				answer.add(Answer);				
				i++;
			} 
			numberOfCorrectAnswer.add(count); 
			int index= numberOfAnswer.size() - 1;
			//if one right answer score is 5 points, two right answer score is 10 points and three right answer score is 15 point;
			if(numberOfAnswer.get(index) == 1){
				score.add(5);
			}else if(numberOfAnswer.get(index) == 2){
				score.add(10);
			}else if(numberOfAnswer.get(index) == 3){
				score.add(15);
			}else{
				System.out.print("\nCannot do the scoring...");
			}
			System.out.printf("\nThere are %d with %d correct\nSucessfully added to our system...\n",numberOfAnswer.get(index),numberOfCorrectAnswer.get(index));
		}
		
	}
	public void editQuiz(){
		Scanner sc = new Scanner(System.in);
		//view the availabel quiz in the system
		int i = 0,j = 0;
		int count = 0;
		String ch;
		String Question, Answer;
		int index;
		while(i < question.size()){
			System.out.printf("\n%d.Question: %s",i+1,question.get(i));
			while( j < numberOfAnswer.get(i)){
				System.out.printf("\n\t%d.%s",j+1,answer.get(j));
				j++;
			}
			j=0;
			i++;
		}
		i=0;
		j=0;
		int indexofAnswer=0;
		System.out.print("\nEnter your index to edit: ");
		index = sc.nextInt();
		index = index - 1;
		if(index < question.size()){
			System.out.print("\nYou can edit...");
			System.out.print("\nEnter your question to replace: ");
			Question = sc.nextLine();
			Question = sc.nextLine();
			question.set(index, Question);
			//Need to find the location of the index
			int answerIndex = 0;
			int correctAnswerIndex = 0;
			i = 0;
			j = 0;
			while(i < numberOfAnswer.size()){
				if(j < numberOfAnswer.get(i) && (i < index)){
					answerIndex++;
					j++;
				}
				i++;
			}
			i = 0;
			j = 0;
			while(i < numberOfCorrectAnswer.size()){
				if(j < numberOfCorrectAnswer.get(i) && (i < index) ){
					correctAnswerIndex++;
					j++;
				}
				i++;
			}
			//Display the correct index
			i = 0;
			j = 0;
			while(i < numberOfCorrectAnswer.get(correctAnswerIndex)){
				System.out.printf("\nIndex of correct answer is %d",indexOfCorrectAnswer.get(correctAnswerIndex + i));
				i++;
			}
			while(j < numberOfAnswer.get(answerIndex)){
				System.out.print("\nEnter your answer to replace: ");
				Answer = sc.nextLine();
				answer.set(answerIndex + j ,Answer);
				j++;
			}
		}
	}
	public void deleteQuiz(){
		Scanner sc = new Scanner(System.in);
		//view the availabel quiz in the system
		int i = 0,j = 0;
		int index;
		while(i < question.size()){
			System.out.printf("\n%d.Question: %s",i+1,question.get(i));
			while( j < numberOfAnswer.get(i)){
				System.out.printf("\n\t%d.%s",j+1,answer.get(j));
				j++;
			}
			j=0;
			i++;
		}
		i=0;
		j=0;
		System.out.print("\nEnter your index to delete: ");
		index = sc.nextInt();
		index = index-1;
		if(index <= question.size()){
			System.out.print("\nYou can delete...");
			
			//Need to find the location of the index
			int answerIndex = 0;
			int correctAnswerIndex = 0;
			i = 0;
			j = 0;
			while(i < numberOfAnswer.size()){
				if(j < numberOfAnswer.get(i) && ((i < index) || (i==0))){
					answerIndex++;
					j++;
				}
				i++;
			}
			i = 0;
			j = 0;
			while(i < numberOfCorrectAnswer.size()){
				if(j < numberOfCorrectAnswer.get(i) && ((i < index) || (i==0))){
					correctAnswerIndex++;
					j++;
				}
				i++;
			}
			//Display the correct index
			i = 0;
			j = 0;
			while(j < numberOfAnswer.get(answerIndex)){
				answer.remove(answerIndex + j);
				j++;
			}
			while(i < numberOfCorrectAnswer.get(correctAnswerIndex)){
				indexOfCorrectAnswer.remove(correctAnswerIndex + i);
				i++;
			}
			numberOfAnswer.remove(index);
			score.remove(index);
			numberOfCorrectAnswer.remove(index);
			question.remove(index);
		}
	}
}
public class quizSystem{
	public static void main(String[] args) {
		quiz q = new quiz();
		int choice;
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("Quiz System\nPress[1] Add question and answer to the quiz system\nPress[2] Editing the question and answer of the quiz system\nPress[3] Delete question and answer from the quiz system\nEnter your choice: ");
			choice = sc.nextInt();
			if(choice == 1){
				q.addQuestion();
			}else if(choice == 2){
				q.editQuiz();
			}else if(choice == 3){
				q.deleteQuiz();
			}else{
				System.out.print("Please input again... \n\n");
			}
		}
  
	}
}