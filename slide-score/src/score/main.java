package score;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
	static int team = 0;
	static int superviser = 0;
	static int score_flag = 0;

	public static ArrayList<team> t = new ArrayList<team>();
	static ArrayList<superviser> s = new ArrayList<superviser>();
	public static ArrayList<score> score = new ArrayList<score>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hi");

		Scanner sc = new Scanner(System.in);

		System.out.print("How many team? : ");
		team = sc.nextInt();

		System.out.print("How many superviser? : ");
		superviser = sc.nextInt();

		int[] team_number = Insert_team_number(team);
		int[] superviser_number = Insert_superviser_number(superviser);

		for (int i = 0; i < superviser; i++) {
			superviser sv = new superviser(superviser_number[i], team);
			sv.insert_score(team_number);
			s.add(sv);
			System.out.println();
		}

		for (int i = 0; i < team; i++) {
			team te = new team(team_number[i], superviser);
			t.add(te);
			System.out.println();
		}

		// 6
		cal_score();

	}

	private static int[] Insert_team_number(int team) {
		int[] result = new int[team];
		for (int i = 0; i < team; i++) {
			result[i] = i + 1;
		}
		return result;
	}

	private static int[] Insert_superviser_number(int superviser) {
		int[] result = new int[superviser];
		for (int i = 0; i < superviser; i++) {
			result[i] = i + 1;
		}
		return result;
	}

	private static void cal_score() {
		ArrayList<team> result = new ArrayList<team>();
		team[] buff = new team[team];
		int count_score_flag = superviser;
		int min_score = 1;
		int count = 0;
		int buff_count = 0;

		while (count != team) {
			for (int i = 0; i < t.size(); i++) {
				team temp = t.get(i);
				if (temp.min_score == min_score) {
					buff[count] = temp;
					count++;
				}
			}
			min_score++;
		}
		for (int i = 0; i < team; i++) {
			for (int j = i+1; j < team; j++) {
				if (buff[i].min_score == buff[j].min_score) {
					if (buff[i].count_score == buff[j].count_score) {
						if (buff[i].top_sum == buff[j].top_sum) {
							int buff_a = 0;
							int buff_b = 0;
							for(int k = 0 ; k < buff[i].score.length ; k++) {
								buff_a += buff[i].score[k];
								buff_b += buff[j].score[k];
							}
							if(buff_a > buff_b) {
								team swap_buff = buff[i];
								buff[i] = buff[j];
								buff[j] = swap_buff;
							}
						} else if (buff[i].top_sum > buff[j].top_sum){
							team swap_buff = buff[i];
							buff[i] = buff[j];
							buff[j] = swap_buff;
						}
					} else if(buff[i].count_score < buff[j].count_score) {
						team swap_buff = buff[i];
						buff[i] = buff[j];
						buff[j] = swap_buff;
					}
				}
			}
		}
		for (int i = 0; i < team; i++)
			System.out.println("Add!! back_Number : " + buff[i].back_number + " min_score " + buff[i].min_score
					+ " score_count : " + buff[i].count_score + " top_sum : " + buff[i].top_sum);
	}
}
