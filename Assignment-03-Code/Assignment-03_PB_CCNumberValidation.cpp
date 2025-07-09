#include <iostream>
#include <vector>
#include <cctype>
#include <iomanip>
using namespace std;
bool isvalidcc(const string& num) { //special num 48
	bool valid = false;
	int totalEvens = 0;
	int totalOdds = 0;

	for (int i = num.length() - 1; i > 0; i -= 2) {
		int j  = num.at(i - 1) - 48;
		switch(j) {
			case 5: {
				totalEvens += 1;
				break;
			}
			case 6: {
				totalEvens += 3;
				break;
			}
			case 7: {
				totalEvens += 5;
				break;
			}
			case 8: {
				totalEvens += 7;
				break;
			}
			case 9: {
				totalEvens += 9;
				break;
			}
			default: {
				totalEvens += j * 2;
				break;
			}
		}
		totalOdds += (num.at(i) - 48);
	}
	if ((totalEvens + totalOdds) % 10 == 0) {
		valid = true;
	}
	return valid;
}

int main()
{
	//
	// PLEASE DO NOT CHANGE function main
	//
	vector<string> cardnumbers = {
		 "371449635398431", "4444444444444448", "4444424444444440", "4110144110144115",
		"4114360123456785", "4061724061724061", "5500005555555559", "5115915115915118",
		"5555555555555557", "6011016011016011", "372449635398431", "4444544444444448",
		"4444434444444440", "4110145110144115", "4124360123456785", "4062724061724061",
		"5501005555555559", "5125915115915118", "5556555555555557", "6011116011016011",
		 "372449635397431", "4444544444444448", "4444434444544440", "4110145110184115",
		"4124360123457785", "4062724061724061", "5541005555555559", "5125115115915118",
		"5556551555555557", "6011316011016011"
	};

	int i;
	vector<string>::iterator itr;

	for (i = 1, itr = cardnumbers.begin(); itr != cardnumbers.end(); ++itr, i++) {
		cout << setw(2) << i << " "
			<< setw(17) << *itr
			<< ((isvalidcc(*itr)) ? " is valid" : " is not valid") << endl;
	}

	return 0;
}