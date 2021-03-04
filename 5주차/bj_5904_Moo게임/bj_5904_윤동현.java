import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());

		long moo = 3;
		long index = 0;
		while(moo < N) {
			index++;
			moo = 2*moo + (index+3);
		}

		while(true) {
			long preMoo = (moo-index-3)/2;
			if(N <= preMoo) {
				index--;
				moo = preMoo;
			} else if(N > preMoo+index+3) {
				N -= (preMoo+index+3);
				index--;
				moo = preMoo;
			} else {
				N -= preMoo;
				break;
			}
		}

		System.out.println((N==1)?"m":"o");

		br.close();
	}
}//end class