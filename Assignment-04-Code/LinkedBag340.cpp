//	LinkedBag340.cpp
//	Created by: CSC340
#include "LinkedBag.h"
#include <cstdlib>
#include <ctime>
/*
===>					<===
===>  PLEASE ADD CODE	<===
===>					<===
*/

	template<typename ItemType>
	bool LinkedBag<ItemType>::removeSecondNode340() {
		bool result = false;
		Node<ItemType>* nextNode = this->headPtr->getNext();
		if (nextNode != nullptr) {
			this->headPtr->setNext(nextNode->getNext());
			result = true;
		}
		return result;
	}

	template<typename ItemType>
	bool LinkedBag<ItemType>::addEnd340(const ItemType& entry) {
		bool result = false;
		Node<ItemType>* newNode = new Node<ItemType>(entry);
		Node<ItemType>* currentPtr = this->headPtr;
		while (currentPtr->getNext() != nullptr) {
			currentPtr = currentPtr->getNext();
		}
		currentPtr->setNext(newNode);
		result = true;
		return result;
	}

	template<typename ItemType>
	int LinkedBag<ItemType>::getCurrentSize340Iterative() const {
		int size = 0;
		Node<ItemType>* currentPtr = this->headPtr;
		while (currentPtr != nullptr) {
			size++;
			currentPtr = currentPtr->getNext();
		}
		return size;
	}

	template<typename ItemType>
	int LinkedBag<ItemType>::getCurrentSize340Recursive() const {
		return getCurrentSize340RecursiveHelper(this->headPtr);
	}

	template<typename ItemType>
	int LinkedBag<ItemType>::getCurrentSize340RecursiveNoHelper() const {
		static Node<ItemType>* currentSizePtr = this->headPtr;
		static int currentSizeNoHelp = 0;
		if (currentSizePtr == nullptr) {
			return currentSizeNoHelp;
		}
		else {
			currentSizePtr = currentSizePtr->getNext();
			currentSizeNoHelp++;
			return getCurrentSize340RecursiveNoHelper();
		}
	}

	template<typename ItemType>
	int LinkedBag<ItemType>::getFrequencyOf340Recursive(const ItemType& entry) const {
		return getFrequencyOf340RecursiveHelper(this->headPtr,entry);
	}

	template<typename ItemType>
	int LinkedBag<ItemType>::getFrequencyOf340RecursiveNoHelper(const ItemType& entry) const {
		static Node<ItemType>* frequencyRecursivePtr = this->headPtr;
		static int frequencyRecursiveCount = 0;
		if (frequencyRecursivePtr == nullptr) {
			int trueRecursiveCount = frequencyRecursiveCount;
			frequencyRecursivePtr = this->headPtr;
			frequencyRecursiveCount = 0;
			return trueRecursiveCount;
		}
		else if (frequencyRecursivePtr->getItem() == entry) {
			frequencyRecursiveCount++;
			frequencyRecursivePtr = frequencyRecursivePtr->getNext();
			return getFrequencyOf340RecursiveNoHelper(entry);
		}
		else {
			frequencyRecursivePtr = frequencyRecursivePtr->getNext();
			return getFrequencyOf340RecursiveNoHelper(entry);
		}
	}

	template<typename ItemType>
	ItemType LinkedBag<ItemType>::removeRandom340() {
		ItemType result;
		srand(time(0));
		unsigned int randomNum = rand() % this->getCurrentSize();
		if (randomNum == 0) {
			result = this->headPtr->getItem();
			this->headPtr = this->headPtr->getNext();
		}
		else if (randomNum == this->getCurrentSize()) {
			Node<ItemType>* currentPtr = this->headPtr;
			while (currentPtr->getNext()->getNext() != nullptr) {
				currentPtr = currentPtr->getNext();
			}
			result = currentPtr->getNext()->getItem();
			currentPtr->setNext(nullptr);
		}
		else {
			Node<ItemType>* currentPtr = this->headPtr;
			while (randomNum > 1) {
				currentPtr = currentPtr->getNext();
				randomNum--;
			}
			Node<ItemType>* currentNextPtr = currentPtr->getNext();
			result = currentNextPtr->getItem();
			currentPtr->setNext(currentNextPtr->getNext());
			itemCount--;
		}
		return result;
	}

	template<typename ItemType>
	int LinkedBag<ItemType>::getCurrentSize340RecursiveHelper(Node<ItemType>* currentPtr) const {
		if (currentPtr->getNext() == nullptr) {
			return 1;
		}
		else {
			return 1 + getCurrentSize340RecursiveHelper(currentPtr->getNext());
		}
	}

	template<typename ItemType>
	int LinkedBag<ItemType>::getFrequencyOf340RecursiveHelper(Node<ItemType>* currentPtr, const ItemType& entry) const {
		if (currentPtr == nullptr) {
			return 0;
		}
		else if (currentPtr->getItem() == entry) {
			return 1 + getFrequencyOf340RecursiveHelper(currentPtr->getNext(), entry);
		}
		else {
			return getFrequencyOf340RecursiveHelper(currentPtr->getNext(), entry);
		}
	}