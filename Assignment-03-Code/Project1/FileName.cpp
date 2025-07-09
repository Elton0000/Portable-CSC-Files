#include <iostream>
#include <fstream>
#include <map>
#include <vector>
#include <string>
#include <iterator>
#include <cctype>
using namespace std;

void loadMessage() {
	cout << "! Opening data file... C:\\Users\\MickeyMouse\\AbsolutePath\\DB\\Data.CS.SFSU.txt\n";
	cout << "<!>ERROR<!> ===> File could not be opened.\n";
	cout << "<!>ERROR<!> ===> Provided file path: C:\\Users\\MickeyMouse\\AbsolutePath\\DB\\Data.CS.SFSU.txt\n";
	cout << "<!>Enter the CORRECT data file path: ";
}

void displayWelcome(map<string, multimap<string, string>> dictionary) {
	// word -> part of speech -> definitions
	int totalDefinitions = 0;
	 
	for (map<string, multimap<string, string>>::iterator itr = dictionary.begin(); itr != dictionary.end(); itr++) {
//iterate through all words
		for (auto p : itr->second) { //at every added definition, increment total definitions by 1
			totalDefinitions++;
		}
	}
	cout << "====== DICTIONARY 340 C++ =====\n";
	cout << "------ Keywords: " << dictionary.size() << "\n";
	cout << "------ Definitions: " <<  totalDefinitions << "\n\n";
}

void loadDictionary(map<string, multimap<string, string>>& dictionary) {
	fstream ioFile;
	string filepath;
	cin >> filepath;
	cin.ignore();

	ioFile.open(filepath, ios::in);
	string line, word, partOfSpeech, definition;
	//book|noun -=>> A set of pages.|verb -=>> To arrange something on a particular date.|verb -=>> to arrange for someone to have a seat on a plane.|noun -=>> A written work published in printed or electronic form. 
	//parts of speech lie between | and -=>> 
	//definitions are between -=>> and | or -=>> to last string of line
	while (!ioFile.eof()) {
		getline(ioFile, line);

		int firstBar = line.find('|');
		int firstArrow = line.find("-=>>");
		size_t j = firstArrow;
		word = line.substr(0, firstBar);
		multimap<string, string>placeholder; // part of speech -> definitions

		for (size_t i = firstBar; i != string::npos; i = line.find('|',i + 1)) { //finds every | symbol in a given line
			partOfSpeech = line.substr(i + 1, j - i - 2);
			if (line.find('|', i + 1) == string::npos) {
				definition = line.substr(j + 5, line.length());
			}
			else {
				definition = line.substr(j + 5, line.find('|', i + 1) - j - 5);
			}
			j = line.find("-=>>", j + 1);
			placeholder.emplace(partOfSpeech, definition);
		}
		dictionary.emplace(word, placeholder);
	}
	ioFile.close();
}

void trim(string& input) {
	int indexOfFirst = 0;
	int indexOfLast = input.length();
	
	if (input.empty()) {
		return;
	}
	else {
		for (indexOfLast; input.at(indexOfLast - 1) == ' '; indexOfLast--);
		for (indexOfFirst; input.at(indexOfFirst) == ' '; indexOfFirst++);
		input = input.replace(indexOfLast,input.length(),"").replace(0, indexOfFirst, "");
	}

}

string convertToLower(string& input) {
	getline(cin,input);
	trim(input);
	if (input._Equal("!Q")) {
		return "!Q";
	}
	string reword = "";
	for (int i = 0; i < input.size(); i++) {
		reword += static_cast<char>(tolower(input.at(i)));
	}
	input = reword;
	return input;
}

vector<string> splice(string input) {
	string word = "";
	vector<string> userInputs = {};
	int i, j;
	for (i = 0; i < input.length(); i = 0) {
		for (j = i; input.at(j) != ' '; j++) {
			word += input.at(j);
		}
		userInputs.push_back(word);
		word = "";
		input = input.substr(j, input.length());
		trim(input);
	}
}

void search(map<string,multimap<string,string>> dictionary) {
	int searchCounter = 1;
	map<string, multimap<string, string>>::iterator itr;
	string input;
	vector<string> splicedInputs = splice(convertToLower(input));
	cout << "Search [" << searchCounter << "] : ";
	while (!splicedInputs[0]._Equal("!Q")) {
		cout << "|\n";
		itr = dictionary.find(splicedInputs[0]); //all words are saved as lowercase, need to change first characters to upper
		if (itr == dictionary.end()) {
			cout << "<NOT FOUND> To be considered for the next release. Thank you.\n";
		}
		else {
			for (auto p : dictionary.find(splicedInputs[0])->second) {
				char first = toupper(splicedInputs[0].at(0));
				splicedInputs[0] = first + splicedInputs[0].substr(1, splicedInputs[0].length());
				cout << splicedInputs[0] << " [" << p.first << "] : " << p.second << endl;
			}
		}
		cout << "|\n";
		searchCounter++;
		cout << "Search [" << searchCounter << "] : ";
	}
	cout << "\n-----THANK YOU-----";
}
//../Data.CS.SFSU.txt
int main() {
	 // char '|' to signal part of speech, string "-=>>" to signal a definition, 1 line 1 word + its definitions
	//each word has: 1 associated name, x parts of speech, x definitions for that part of speech

	loadMessage();
	map<string,multimap<string,string>> dictionary; // string -> access word looking for -> word has a part of speech an associated container of definitions
	loadDictionary(dictionary);
	displayWelcome(dictionary);
	search(dictionary);
	return 0;
}

