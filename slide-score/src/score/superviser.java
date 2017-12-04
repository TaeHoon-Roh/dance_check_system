package score;

import java.util.Random;

public class superviser {
	int number;
	int team;
	int[] score;
	superviser(int flag, int team){
		this.number = flag;
		this.team = team;
		this.score = new int[team];
		
	}

	public void insert_score(int[] team_number){
		for(int i = 0 ; i < score.length ; i++) {
			score[i] = i+1;
		}
		Random r = new Random();
		
		for(int i = 0 ; i < 20 ; i++) {
		
			int a = r.nextInt(score.length);
			int b = r.nextInt(score.length);
			int c = score[a];
			score[a] = score[b];
			score[b] = c;
		}
		
		for(int i = 0 ; i < score.length ; i++) {
			score s = new score(number, team_number[i], score[i]);
			main.score.add(s);
			System.out.print(score[i] + "\t");
		}
	}
}
