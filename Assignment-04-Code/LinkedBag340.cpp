//	LinkedBag340.cpp
//	Created by: CSC340
#include "LinkedBag.h"
#include "Node.h"
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
			this->headPtr->setNext(nextNode->getNext())
			result = true;
		}
		return result;
	}

	template<typename ItemType>
	bool LinkedBag<ItemType>::addEnd340(const ItemType& entry) {
		bool result = false;
		Node<ItemType> newNode = Node<ItemType>(entry);
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
		while (currentPtr->getNext() != nullptr) {
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
		return 0;
	}

	template<typename ItemType>
	int LinkedBag<ItemType>::getFrequencyOf340Recursive(const ItemType& entry) const {
		return getFrequencyOf340Recursive(this->headPtr,entry);
	}

	template<typename ItemType>
	int LinkedBag<ItemType>::getFrequencyOf340RecursiveNoHelper(const ItemType&) const {
		return 0;
	}

	template<typename ItemType>
	ItemType LinkedBag<ItemType>::removeRandom340() {
		return 0;
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