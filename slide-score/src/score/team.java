package score;

import java.util.Arrays;

public class team {

	int back_number;
	int[] score;
	int top_score;
	int min_score;
	int count_score;
	int top_sum;
	int flag;

	team(int team_number, int superviser) {
		this.back_number = team_number;
		this.top_score = 1;
		this.min_score = 100;
		this.count_score = 0;
		this.flag = superviser/2;
		this.top_sum = 0;
		this.score = new int[superviser];
		insert_score();
	}

	public void insert_score() {
		int score_flag = 0;
		for (int i = 0; i < main.score.size(); i++) {

			score sc = main.score.get(i);
			if (sc.team_number == back_number) {
				score[score_flag] = sc.score;
				score_flag++;
				if (score_flag == score.length) {
					break;
				}
			}
		}

		cal_score();
		print_team_score();

	}

	public void cal_score() {
		Arrays.sort(score);
		for(int i = 0 ; i < score.length ; i++) {
			System.out.print(score[i] + " " );
		}
		top_score = score[0];
		min_score = score[flag];
		count_score = flag + 1;
		for(int i = flag ; ; i++) {
			if((i+1) == score.length) {
				break;
			}
			if(score[i] == score[i+1]) {
				count_score++;
			} else {
				break;
			}
		}
		for(int i = 0 ; i < count_score ; i++) {
			top_sum += score[i];
		}
		
	}
	
	public void print_team_score() {
		System.out.println("Team number : " + back_number + " Score!!");
		for(int i = 0 ; i < count_score; i++) {
			System.out.print(score[i] + " ");
		}
		System.out.println();
		System.out.println("Top score is : " + top_score + " end Min_score is : " + min_score + " count_score : " + count_score + " top_sum : " + top_sum);
	}
}
