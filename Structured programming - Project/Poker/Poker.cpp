//Name: Vinicius Parzanini
//Function: Poker
//Date: 03/04/2021

#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>
#include <vector>
#include <fstream>

using namespace std;

//Function to create a deck
void cards(int* card)
{
    //variables
    const int deck = 52, dia = 13, hea = 13, spa = 13, clu = 13;
    int d = 0, h = 0, s = 0, c = 0;

    //all cards
    int cards[deck];
    //Array diamond cards
    int diamonds[dia] = {1,5,9,13,17,21,25,29,33,37,41,45,49};
    //Array hearts cards
    int hearts[hea] = {2,6,10,14,18,22,26,30,34,38,42,46,50};
    //Array spades cards
    int spades[spa] = {3,7,11,15,19,23,27,31,35,39,43,47,51};
    //Array clubs cards
    int clubs[clu] = {4,8,12,16,20,24,28,32,36,40,44,48,52};

    for(int i = 0; i < 52; i++)
    {
        if(i % 4 == 0)
        {
            //adding diamonds into array
            card[i] = diamonds[d];
            d++;
        }
        else if(i % 4 == 1)
        {
            //adding hearts into array
            card[i] = hearts[h];
            h++;
        }
        else if(i % 4 == 2)
        {
            //adding spades into array
            card[i]= spades[s];
            s++;
        }
         if(i % 4 == 3)
        {
            //adding clubs into array
            card[i] = clubs[c];
            c++;
        }
    }
}

//The purpose of this function is to shuffle the cards in the way that is not repeated.
//divide all the cards by 2 and them passing to the main function
void shuffleGive(int* h1, int* h2)
{
    int total[52];//total because it is the total of cards
    int hand1[26], hand2[26];//to divide
    int temp;
    int a = 0, b = 0, c = 0;//increment
    
    //calling the random function
    srand(time(NULL));//It is using the real time to keep the cards always random

    //grabbing the cards from another function
    cards(total);

    //shuffling the cards
    for(int i = 0; i < 52; i++)
    {
        {
            c = (rand()%52);
            temp = total[i];
            total[i] = total[c];
            total[c] = temp;
        }
    }
    //for loop to divide the cards
    for(int i = 0; i < 52; i++)
    {
        if(i % 2 == 0)
        {
            h1[a] = total[i];
            a++;
        }
        if(i % 2 == 1)
        {
            h2[b] = total[i];
            b++;
        }
    }
}

//The purpose of this function is to print the cards the way it is
void printCard(int *print)
{
    //Printing the card in the way that the player understands(didn't find a way to do this in a loop).
    //We don't need brackets if it is only line of if or whatever else, so I saved some lines.
    if(*print == 1)
    cout << "AD ";
    else if(*print == 2)
    cout << "AH ";
    else if(*print == 3)
    cout << "AS ";
    else if(*print == 4)
    cout << "AC ";
    else if(*print == 5)
    cout << "2D ";
    else if(*print == 6)
    cout << "2H ";
    else if(*print == 7)
    cout << "2S ";
    else if(*print == 8)
    cout << "2C ";
    else if(*print == 9)
    cout << "3D ";
    else if(*print == 10)
    cout << "3H ";
    else if(*print == 11)
    cout << "3S ";
    else if(*print == 12)
    cout << "3C ";
    else if(*print == 13)
    cout << "4D ";
    else if(*print == 14)
    cout << "4H ";
    else if(*print == 15)
    cout << "4S ";
    else if(*print == 16)
    cout << "4C ";
    else if(*print == 17)
    cout << "5D ";
    else if(*print == 18)
    cout << "5H ";
    else if(*print == 19)
    cout << "5S ";
    else if(*print == 20)
    cout << "5C ";
    else if(*print == 21)
    cout << "6D ";
    else if(*print == 22)
    cout << "6H ";
    else if(*print == 23)
    cout << "6S ";
    else if(*print == 24)
    cout << "6C ";
    else if(*print == 25)
    cout << "7D ";
    else if(*print == 26)
    cout << "7H ";
    else if(*print == 27)
    cout << "7S ";
    else if(*print == 28)
    cout << "7C ";
    else if(*print == 29)
    cout << "8D ";
    else if(*print == 30)
    cout << "8H ";
    else if(*print == 31)
    cout << "8S ";
    else if(*print == 32)
    cout << "8C ";
    else if(*print == 33)
    cout << "9D ";
    else if(*print == 34)
    cout << "9H ";
    else if(*print == 35)
    cout << "9S ";
    else if(*print == 36)
    cout << "9C ";
    else if(*print == 37)
    cout << "10D ";
    else if(*print == 38)
    cout << "10H ";
    else if(*print == 39)
    cout << "10S ";
    else if(*print == 40)
    cout << "10C ";
    else if(*print == 41)
    cout << "JD "; 
    else if(*print == 42)
    cout << "JH ";
    else if(*print == 43)
    cout << "JS ";
    else if(*print == 44)
    cout << "JC ";
    else if(*print == 45)
    cout << "QD ";
    else if(*print == 46)
    cout << "QH ";
    else if(*print == 47)
    cout << "QS ";
    else if(*print == 48)
    cout << "QC ";
    else if(*print == 49)
    cout << "KD ";
    else if(*print == 50)
    cout << "KH ";
    else if(*print == 51)
    cout << "KS ";
    else if(*print == 52)
    cout << "KC ";
}

//Winning condition
int winningCondition(int *p1, int *bot)
{
    //variables
    int as1 = 0, as2 = 0;//pair of AS
    int ten1 = 0, ten2 = 0;//pair of 10s.
    int biggest1 = 0, biggest2 = 0;//High card
    
    //pair of A
    //comparing player A of diamonds with A of hearts
    if(((*p1 == 1) && (*(p1 + 1) == 2)) || ((*p1 == 2) && (*(p1 + 1) == 1)))// card 1 and 2
        as1 = 1;
    else if(((*(p1 + 1) == 1) && (*(p1 + 2) == 2)) || ((*(p1 + 1) == 2) && (*(p1 + 2) == 1)))// card 2 and 3
        as1 = 1;
    else if(((*(p1 + 2) == 1) && (*(p1 + 3) == 2)) || ((*(p1 + 2) == 2) && (*(p1 + 3) == 1)))// card 3 and 4
        as1 = 1;
    else if(((*(p1 + 3) == 1) && (*(p1 + 4) == 2)) || ((*(p1 + 3) == 2) && (*(p1 + 4) == 1)))// card 4 and 5
        as1 = 1;
    else if(((*(p1 + 4) == 1) && (*p1 == 2)) || ((*(p1 + 4) == 2) && (*p1 == 1)))// card 5 and 1
        as1 = 1;
    else if(((*(p1 + 1) == 1) && (*(p1 + 3) == 2)) || ((*(p1 + 1) == 2) && (*(p1 + 3) == 1)))// card 2 and 4
        as1 = 1;
    else if(((*(p1 + 2) == 1) && (*p1 == 2)) || ((*(p1 + 2) == 2) && (*p1 == 1)))// card 3 and 1
        as1 = 1;
    else if(((*(p1 + 2) == 1) && (*(p1 + 4) == 2)) || ((*(p1 + 2) == 2) && (*(p1 + 4) == 1)))// card 3 and 5
        as1 = 1;
    else if(((*(p1 + 3) == 1) && (*p1 == 2)) || ((*(p1 + 3) == 2) && (*p1 == 1)))// card 4 and 1
        as1 = 1;
    else if(((*(p1 + 1) == 1) && (*(p1 + 4) == 2)) || ((*(p1 + 1) == 2) && (*(p1 + 4) == 1)))// card 2 and 5
        as1 = 1;

    //comparing player A of hearts with A of spades
    if(((*p1 == 2) && (*(p1 + 1) == 3)) || ((*p1 == 3) && (*(p1 + 1) == 2)))// card 1 and 2
        as1 = 1;
    else if(((*(p1 + 1) == 2) && (*(p1 + 2) == 3)) || ((*(p1 + 1) == 3) && (*(p1 + 2) == 2)))// card 2 and 3
        as1 = 1;
    else if(((*(p1 + 2) == 2) && (*(p1 + 3) == 3)) || ((*(p1 + 2) == 3) && (*(p1 + 3) == 2)))// card 3 and 4
        as1 = 1;
    else if(((*(p1 + 3) == 2) && (*(p1 + 4) == 3)) || ((*(p1 + 3) == 3) && (*(p1 + 4) == 2)))// card 4 and 5
        as1 = 1;
    else if(((*(p1 + 4) == 2) && (*p1 == 3)) || ((*(p1 + 4) == 3) && (*p1 == 2)))// card 5 and 1
        as1 = 1;
    else if(((*(p1 + 1) == 2) && (*(p1 + 3) == 3)) || ((*(p1 + 1) == 3) && (*(p1 + 3) == 2)))// card 2 and 4
        as1 = 1;
    else if(((*(p1 + 2) == 2) && (*p1 == 3)) || ((*(p1 + 2) == 3) && (*p1 == 2)))// card 3 and 1
        as1 = 1;
    else if(((*(p1 + 2) == 2) && (*(p1 + 4) == 3)) || ((*(p1 + 2) == 3) && (*(p1 + 4) == 2)))// card 3 and 5
        as1 = 1;
    else if(((*(p1 + 3) == 2) && (*p1 == 3)) || ((*(p1 + 3) == 3) && (*p1 == 2)))// card 4 and 1
        as1 = 1;
    else if(((*(p1 + 1) == 2) && (*(p1 + 4) == 3)) || ((*(p1 + 1) == 3) && (*(p1 + 4) == 2)))// card 2 and 5
        as1 = 1;        
    
    //comparing player A of spades with A of clubs
    if(((*p1 == 3) && (*(p1 + 1) == 4)) || ((*p1 == 4) && (*(p1 + 1) == 3)))// card 1 and 2
        as1 = 1;
    else if(((*(p1 + 1) == 3) && (*(p1 + 2) == 4)) || ((*(p1 + 1) == 4) && (*(p1 + 2) == 3)))// card 2 and 3
        as1 = 1;
    else if(((*(p1 + 2) == 3) && (*(p1 + 3) == 4)) || ((*(p1 + 2) == 4) && (*(p1 + 3) == 3)))// card 3 and 4
        as1 = 1;
    else if(((*(p1 + 3) == 3) && (*(p1 + 4) == 4)) || ((*(p1 + 3) == 4) && (*(p1 + 4) == 3)))// card 4 and 5
        as1 = 1;
    else if(((*(p1 + 4) == 3) && (*p1 == 4)) || ((*(p1 + 4) == 4) && (*p1 == 3)))// card 5 and 1
        as1 = 1;
    else if(((*(p1 + 1) == 3) && (*(p1 + 3) == 4)) || ((*(p1 + 1) == 4) && (*(p1 + 3) == 3)))// card 2 and 4
        as1 = 1;
    else if(((*(p1 + 2) == 3) && (*p1 == 4)) || ((*(p1 + 2) == 4) && (*p1 == 3)))// card 3 and 1
        as1 = 1;
    else if(((*(p1 + 2) == 3) && (*(p1 + 4) == 4)) || ((*(p1 + 2) == 4) && (*(p1 + 4) == 3)))// card 3 and 5
        as1 = 1;
    else if(((*(p1 + 3) == 3) && (*p1 == 4)) || ((*(p1 + 3) == 4) && (*p1 == 3)))// card 4 and 1
        as1 = 1;
    else if(((*(p1 + 1) == 3) && (*(p1 + 4) == 4)) || ((*(p1 + 1) == 4) && (*(p1 + 4) == 3)))// card 2 and 5
        as1 = 1;

    //comparing player A of clubs with A of diamonds
    if(((*p1 == 1) && (*(p1 + 1) == 4)) || ((*p1 == 4) && (*(p1 + 1) == 1)))// card 1 and 2
        as1 = 1;
    else if(((*(p1 + 1) == 1) && (*(p1 + 2) == 4)) || ((*(p1 + 1) == 4) && (*(p1 + 2) == 1)))// card 2 and 3
        as1 = 1;
    else if(((*(p1 + 2) == 1) && (*(p1 + 3) == 4)) || ((*(p1 + 2) == 4) && (*(p1 + 3) == 1)))// card 3 and 4
        as1 = 1;
    else if(((*(p1 + 3) == 1) && (*(p1 + 4) == 4)) || ((*(p1 + 3) == 4) && (*(p1 + 4) == 1)))// card 4 and 5
        as1 = 1;
    else if(((*(p1 + 4) == 1) && (*p1 == 4)) || ((*(p1 + 4) == 4) && (*p1 == 1)))// card 5 and 1
        as1 = 1;
    else if(((*(p1 + 1) == 1) && (*(p1 + 3) == 4)) || ((*(p1 + 1) == 4) && (*(p1 + 3) == 1)))// card 2 and 4
        as1 = 1;
    else if(((*(p1 + 2) == 1) && (*p1 == 4)) || ((*(p1 + 2) == 4) && (*p1 == 1)))// card 3 and 1
        as1 = 1;
    else if(((*(p1 + 2) == 1) && (*(p1 + 4) == 4)) || ((*(p1 + 2) == 4) && (*(p1 + 4) == 1)))// card 3 and 5
        as1 = 1;
    else if(((*(p1 + 3) == 1) && (*p1 == 4)) || ((*(p1 + 3) == 4) && (*p1 == 1)))// card 4 and 1
        as1 = 1;
    else if(((*(p1 + 1) == 1) && (*(p1 + 4) == 4)) || ((*(p1 + 1) == 4) && (*(p1 + 4) == 1)))// card 2 and 5
        as1 = 1;
    
    //comparing player A of clubs with A of hearts
    if(((*p1 == 2) && (*(p1 + 1) == 4)) || ((*p1 == 4) && (*(p1 + 1) == 2)))// card 1 and 2
        as1 = 1;
    else if(((*(p1 + 1) == 2) && (*(p1 + 2) == 4)) || ((*(p1 + 1) == 4) && (*(p1 + 2) == 2)))// card 2 and 3
        as1 = 1;
    else if(((*(p1 + 2) == 2) && (*(p1 + 3) == 4)) || ((*(p1 + 2) == 4) && (*(p1 + 3) == 2)))// card 3 and 4
        as1 = 1;
    else if(((*(p1 + 3) == 2) && (*(p1 + 4) == 4)) || ((*(p1 + 3) == 4) && (*(p1 + 4) == 2)))// card 4 and 5
        as1 = 1;
    else if(((*(p1 + 4) == 2) && (*p1 == 4)) || ((*(p1 + 4) == 4) && (*p1 == 2)))// card 5 and 1
        as1 = 1;
    else if(((*(p1 + 1) == 2) && (*(p1 + 3) == 4)) || ((*(p1 + 1) == 4) && (*(p1 + 3) == 2)))// card 2 and 4
        as1 = 1;
    else if(((*(p1 + 2) == 2) && (*p1 == 4)) || ((*(p1 + 2) == 4) && (*p1 == 2)))// card 3 and 1
        as1 = 1;
    else if(((*(p1 + 2) == 2) && (*(p1 + 4) == 4)) || ((*(p1 + 2) == 4) && (*(p1 + 4) == 2)))// card 3 and 5
        as1 = 1;
    else if(((*(p1 + 3) == 2) && (*p1 == 4)) || ((*(p1 + 3) == 4) && (*p1 == 2)))// card 4 and 1
        as1 = 1;
    else if(((*(p1 + 1) == 2) && (*(p1 + 4) == 4)) || ((*(p1 + 1) == 4) && (*(p1 + 4) == 2)))// card 2 and 5
        as1 = 1;

    //comparing player A of diamonds with A of spades
    if(((*p1 == 1) && (*(p1 + 1) == 3)) || ((*p1 == 3) && (*(p1 + 1) == 1)))// card 1 and 2
        as1 = 1;
    else if(((*(p1 + 1) == 1) && (*(p1 + 2) == 3)) || ((*(p1 + 1) == 3) && (*(p1 + 2) == 1)))// card 2 and 3
        as1 = 1;
    else if(((*(p1 + 2) == 1) && (*(p1 + 3) == 3)) || ((*(p1 + 2) == 3) && (*(p1 + 3) == 1)))// card 3 and 4
        as1 = 1;
    else if(((*(p1 + 3) == 1) && (*(p1 + 4) == 3)) || ((*(p1 + 3) == 3) && (*(p1 + 4) == 1)))// card 4 and 5
        as1 = 1;
    else if(((*(p1 + 4) == 1) && (*p1 == 3)) || ((*(p1 + 4) == 3) && (*p1 == 1)))// card 5 and 1
        as1 = 1;
    else if(((*(p1 + 1) == 1) && (*(p1 + 3) == 3)) || ((*(p1 + 1) == 3) && (*(p1 + 3) == 1)))// card 2 and 4
        as1 = 1;
    else if(((*(p1 + 2) == 1) && (*p1 == 3)) || ((*(p1 + 2) == 3) && (*p1 == 1)))// card 3 and 1
        as1 = 1;
    else if(((*(p1 + 2) == 1) && (*(p1 + 4) == 3)) || ((*(p1 + 2) == 3) && (*(p1 + 4) == 1)))// card 3 and 5
        as1 = 1;
    else if(((*(p1 + 3) == 1) && (*p1 == 3)) || ((*(p1 + 3) == 3) && (*p1 == 1)))// card 4 and 1
        as1 = 1;
    else if(((*(p1 + 1) == 1) && (*(p1 + 4) == 3)) || ((*(p1 + 1) == 3) && (*(p1 + 4) == 1)))// card 2 and 5
        as1 = 1;
    
    //pair of A (BOT)
    //comparing bot A of diamonds with A of hearts
    if(((*bot == 1) && (*(bot + 1) == 2)) || ((*bot == 2) && (*(bot + 1) == 1)))// card 1 and 2
        as2 = 1;
    else if(((*(bot + 1) == 1) && (*(bot + 2) == 2)) || ((*(bot + 1) == 2) && (*(bot + 2) == 1)))// card 2 and 3
        as2 = 1;
    else if(((*(bot + 2) == 1) && (*(bot + 3) == 2)) || ((*(bot + 2) == 2) && (*(bot + 3) == 1)))// card 3 and 4
        as2 = 1;
    else if(((*(bot + 3) == 1) && (*(bot + 4) == 2)) || ((*(bot + 3) == 2) && (*(bot + 4) == 1)))// card 4 and 5
        as2 = 1;
    else if(((*(bot + 4) == 1) && (*bot == 2)) || ((*(bot + 4) == 2) && (*bot == 1)))// card 5 and 1
        as2 = 1;
    else if(((*(bot + 1) == 1) && (*(bot + 3) == 2)) || ((*(bot + 1) == 2) && (*(bot + 3) == 1)))// card 2 and 4
        as2 = 1;
    else if(((*(bot + 2) == 1) && (*bot == 2)) || ((*(bot + 2) == 2) && (*bot == 1)))// card 3 and 1
        as2 = 1;
    else if(((*(bot + 2) == 1) && (*(bot + 4) == 2)) || ((*(bot + 2) == 2) && (*(bot + 4) == 1)))// card 3 and 5
        as2 = 1;
    else if(((*(bot + 3) == 1) && (*bot == 2)) || ((*(bot + 3) == 2) && (*bot == 1)))// card 4 and 1
        as2 = 1;
    else if(((*(bot + 1) == 1) && (*(bot + 4) == 2)) || ((*(bot + 1) == 2) && (*(bot + 4) == 1)))// card 2 and 5
        as2 = 1;

    //comparing bot A of hearts with A of spades
    if(((*bot == 2) && (*(bot + 1) == 3)) || ((*bot == 3) && (*(bot + 1) == 2)))// card 1 and 2
        as2 = 1;
    else if(((*(bot + 1) == 2) && (*(bot + 2) == 3)) || ((*(bot + 1) == 3) && (*(bot + 2) == 2)))// card 2 and 3
        as2 = 1;
    else if(((*(bot + 2) == 2) && (*(bot + 3) == 3)) || ((*(bot + 2) == 3) && (*(bot + 3) == 2)))// card 3 and 4
        as2 = 1;
    else if(((*(bot + 3) == 2) && (*(bot + 4) == 3)) || ((*(bot + 3) == 3) && (*(bot + 4) == 2)))// card 4 and 5
        as2 = 1;
    else if(((*(bot + 4) == 2) && (*bot == 3)) || ((*(bot + 4) == 3) && (*bot == 2)))// card 5 and 1
        as2 = 1;
    else if(((*(bot + 1) == 2) && (*(bot + 3) == 3)) || ((*(bot + 1) == 3) && (*(bot + 3) == 2)))// card 2 and 4
        as2 = 1;
    else if(((*(bot + 2) == 2) && (*bot == 3)) || ((*(bot + 2) == 3) && (*bot == 2)))// card 3 and 1
        as2 = 1;
    else if(((*(bot + 2) == 2) && (*(bot + 4) == 3)) || ((*(bot + 2) == 3) && (*(bot + 4) == 2)))// card 3 and 5
        as2 = 1;
    else if(((*(bot + 3) == 2) && (*bot == 3)) || ((*(bot + 3) == 3) && (*bot == 2)))// card 4 and 1
        as2 = 1;
    else if(((*(bot + 1) == 2) && (*(bot + 4) == 3)) || ((*(bot + 1) == 3) && (*(bot + 4) == 2)))// card 2 and 5
        as2 = 1;        
    
    //comparing bot A of spades with A of clubs
    if(((*bot == 3) && (*(bot + 1) == 4)) || ((*bot == 4) && (*(bot + 1) == 3)))// card 1 and 2
        as2 = 1;
    else if(((*(bot + 1) == 3) && (*(bot + 2) == 4)) || ((*(bot + 1) == 4) && (*(bot + 2) == 3)))// card 2 and 3
        as2 = 1;
    else if(((*(bot + 2) == 3) && (*(bot + 3) == 4)) || ((*(bot + 2) == 4) && (*(bot + 3) == 3)))// card 3 and 4
        as2 = 1;
    else if(((*(bot + 3) == 3) && (*(bot + 4) == 4)) || ((*(bot + 3) == 4) && (*(bot + 4) == 3)))// card 4 and 5
        as2 = 1;
    else if(((*(bot + 4) == 3) && (*bot == 4)) || ((*(bot + 4) == 4) && (*bot == 3)))// card 5 and 1
        as2 = 1;
    else if(((*(bot + 1) == 3) && (*(bot + 3) == 4)) || ((*(bot + 1) == 4) && (*(bot + 3) == 3)))// card 2 and 4
        as2 = 1;
    else if(((*(bot + 2) == 3) && (*bot == 4)) || ((*(bot + 2) == 4) && (*bot == 3)))// card 3 and 1
        as2 = 1;
    else if(((*(bot + 2) == 3) && (*(bot + 4) == 4)) || ((*(bot + 2) == 4) && (*(bot + 4) == 3)))// card 3 and 5
        as2 = 1;
    else if(((*(bot + 3) == 3) && (*bot == 4)) || ((*(bot + 3) == 4) && (*bot == 3)))// card 4 and 1
        as2 = 1;
    else if(((*(bot + 1) == 3) && (*(bot + 4) == 4)) || ((*(bot + 1) == 4) && (*(bot + 4) == 3)))// card 2 and 5
        as2 = 1;

    //comparing bot A of clubs with A of diamonds
    if(((*bot == 1) && (*(bot + 1) == 4)) || ((*bot == 4) && (*(bot + 1) == 1)))// card 1 and 2
        as2 = 1;
    else if(((*(bot + 1) == 1) && (*(bot + 2) == 4)) || ((*(bot + 1) == 4) && (*(bot + 2) == 1)))// card 2 and 3
        as2 = 1;
    else if(((*(bot + 2) == 1) && (*(bot + 3) == 4)) || ((*(bot + 2) == 4) && (*(bot + 3) == 1)))// card 3 and 4
        as2 = 1;
    else if(((*(bot + 3) == 1) && (*(bot + 4) == 4)) || ((*(bot + 3) == 4) && (*(bot + 4) == 1)))// card 4 and 5
        as2 = 1;
    else if(((*(bot + 4) == 1) && (*bot == 4)) || ((*(bot + 4) == 4) && (*bot == 1)))// card 5 and 1
        as2 = 1;
    else if(((*(bot + 1) == 1) && (*(bot + 3) == 4)) || ((*(bot + 1) == 4) && (*(bot + 3) == 1)))// card 2 and 4
        as2 = 1;
    else if(((*(bot + 2) == 1) && (*bot == 4)) || ((*(bot + 2) == 4) && (*bot == 1)))// card 3 and 1
        as2 = 1;
    else if(((*(bot + 2) == 1) && (*(bot + 4) == 4)) || ((*(bot + 2) == 4) && (*(bot + 4) == 1)))// card 3 and 5
        as2 = 1;
    else if(((*(bot + 3) == 1) && (*bot == 4)) || ((*(bot + 3) == 4) && (*bot == 1)))// card 4 and 1
        as2 = 1;
    else if(((*(bot + 1) == 1) && (*(bot + 4) == 4)) || ((*(bot + 1) == 4) && (*(bot + 4) == 1)))// card 2 and 5
        as2 = 1;
    
    //comparing bot A of clubs with A of hearts
    if(((*bot == 2) && (*(bot + 1) == 4)) || ((*bot == 4) && (*(bot + 1) == 2)))// card 1 and 2
        as2 = 1;
    else if(((*(bot + 1) == 2) && (*(bot + 2) == 4)) || ((*(bot + 1) == 4) && (*(bot + 2) == 2)))// card 2 and 3
        as2 = 1;
    else if(((*(bot + 2) == 2) && (*(bot + 3) == 4)) || ((*(bot + 2) == 4) && (*(bot + 3) == 2)))// card 3 and 4
        as2 = 1;
    else if(((*(bot + 3) == 2) && (*(bot + 4) == 4)) || ((*(bot + 3) == 4) && (*(bot + 4) == 2)))// card 4 and 5
        as2 = 1;
    else if(((*(bot + 4) == 2) && (*bot == 4)) || ((*(bot + 4) == 4) && (*bot == 2)))// card 5 and 1
        as2 = 1;
    else if(((*(bot + 1) == 2) && (*(bot + 3) == 4)) || ((*(bot + 1) == 4) && (*(bot + 3) == 2)))// card 2 and 4
        as2 = 1;
    else if(((*(bot + 2) == 2) && (*bot == 4)) || ((*(bot + 2) == 4) && (*bot == 2)))// card 3 and 1
        as2 = 1;
    else if(((*(bot + 2) == 2) && (*(bot + 4) == 4)) || ((*(bot + 2) == 4) && (*(bot + 4) == 2)))// card 3 and 5
        as2 = 1;
    else if(((*(bot + 3) == 2) && (*bot == 4)) || ((*(bot + 3) == 4) && (*bot == 2)))// card 4 and 1
        as2 = 1;
    else if(((*(bot + 1) == 2) && (*(bot + 4) == 4)) || ((*(bot + 1) == 4) && (*(bot + 4) == 2)))// card 2 and 5
        as2 = 1;

    //comparing bot A of diamonds with A of spades
    if(((*bot == 1) && (*(bot + 1) == 3)) || ((*bot == 3) && (*(bot + 1) == 1)))// card 1 and 2
        as2 = 1;
    else if(((*(bot + 1) == 1) && (*(bot + 2) == 3)) || ((*(bot + 1) == 3) && (*(bot + 2) == 1)))// card 2 and 3
        as2 = 1;
    else if(((*(bot + 2) == 1) && (*(bot + 3) == 3)) || ((*(bot + 2) == 3) && (*(bot + 3) == 1)))// card 3 and 4
        as2 = 1;
    else if(((*(bot + 3) == 1) && (*(bot + 4) == 3)) || ((*(bot + 3) == 3) && (*(bot + 4) == 1)))// card 4 and 5
        as2 = 1;
    else if(((*(bot + 4) == 1) && (*bot == 3)) || ((*(bot + 4) == 3) && (*bot == 1)))// card 5 and 1
        as2 = 1;
    else if(((*(bot + 1) == 1) && (*(bot + 3) == 3)) || ((*(bot + 1) == 3) && (*(bot + 3) == 1)))// card 2 and 4
        as2 = 1;
    else if(((*(bot + 2) == 1) && (*bot == 3)) || ((*(bot + 2) == 3) && (*bot == 1)))// card 3 and 1
        as2 = 1;
    else if(((*(bot + 2) == 1) && (*(bot + 4) == 3)) || ((*(bot + 2) == 3) && (*(bot + 4) == 1)))// card 3 and 5
        as2 = 1;
    else if(((*(bot + 3) == 1) && (*bot == 3)) || ((*(bot + 3) == 3) && (*bot == 1)))// card 4 and 1
        as2 = 1;
    else if(((*(bot + 1) == 1) && (*(bot + 4) == 3)) || ((*(bot + 1) == 3) && (*(bot + 4) == 1)))// card 2 and 5
        as2 = 1;
    
    //pair of 10s
    //comparing player 10 of diamonds with 10 of hearts
    if(((*p1 == 37) && (*(p1 + 1) == 38)) || ((*p1 == 38) && (*(p1 + 1) == 37)))// card 1 and 2
        ten1 = 1;
    else if(((*(p1 + 1) == 37) && (*(p1 + 2) == 38)) || ((*(p1 + 1) == 38) && (*(p1 + 2) == 37)))// card 2 and 3
        ten1 = 1;
    else if(((*(p1 + 2) == 37) && (*(p1 + 3) == 38)) || ((*(p1 + 2) == 38) && (*(p1 + 3) == 37)))// card 3 and 4
        ten1 = 1;
    else if(((*(p1 + 3) == 37) && (*(p1 + 4) == 38)) || ((*(p1 + 3) == 38) && (*(p1 + 4) == 37)))// card 4 and 5
        ten1 = 1;
    else if(((*(p1 + 4) == 37) && (*p1 == 38)) || ((*(p1 + 4) == 38) && (*p1 == 37)))// card 5 and 1
        ten1 = 1;
    else if(((*(p1 + 1) == 37) && (*(p1 + 3) == 38)) || ((*(p1 + 1) == 38) && (*(p1 + 3) == 37)))// card 2 and 4
        ten1 = 1;
    else if(((*(p1 + 2) == 37) && (*p1 == 38)) || ((*(p1 + 2) == 38) && (*p1 == 37)))// card 3 and 1
        ten1 = 1;
    else if(((*(p1 + 2) == 37) && (*(p1 + 4) == 38)) || ((*(p1 + 3) == 38) && (*(p1 + 4) == 37)))// card 3 and 5
        ten1 = 1;
    else if(((*(p1 + 3) == 37) && (*p1 == 38)) || ((*(p1 + 3) == 38) && (*p1 == 37)))// card 4 and 1
        ten1 = 1;
    else if(((*(p1 + 1) == 37) && (*(p1 + 4) == 38)) || ((*(p1 + 1) == 38) && (*(p1 + 4) == 37)))// card 2 and 5
        ten1 = 1;

    //comparing player 10 of hearts with 10 of spades
    if(((*p1 == 38) && (*(p1 + 1) == 39)) || ((*p1 == 39) && (*(p1 + 1) == 38)))// card 1 and 2
        ten1 = 1;
    else if(((*(p1 + 1) == 38) && (*(p1 + 2) == 39)) || ((*(p1 + 1) == 39) && (*(p1 + 2) == 38)))// card 2 and 3
        ten1 = 1;
    else if(((*(p1 + 2) == 38) && (*(p1 + 3) == 39)) || ((*(p1 + 2) == 39) && (*(p1 + 3) == 38)))// card 3 and 4
        ten1 = 1;
    else if(((*(p1 + 3) == 38) && (*(p1 + 4) == 39)) || ((*(p1 + 3) == 39) && (*(p1 + 4) == 38)))// card 4 and 5
        ten1 = 1;
    else if(((*(p1 + 4) == 38) && (*p1 == 39)) || ((*(p1 + 4) == 39) && (*p1 == 38)))// card 5 and 1
        ten1 = 1;
    else if(((*(p1 + 1) == 38) && (*(p1 + 3) == 39)) || ((*(p1 + 1) == 39) && (*(p1 + 3) == 38)))// card 2 and 4
        ten1 = 1;
    else if(((*(p1 + 2) == 38) && (*p1 == 39)) || ((*(p1 + 2) == 39) && (*p1 == 38)))// card 3 and 1
        ten1 = 1;
    else if(((*(p1 + 3) == 38) && (*(p1 + 4) == 39)) || ((*(p1 + 3) == 39) && (*(p1 + 4) == 38)))// card 3 and 5
        ten1 = 1;
    else if(((*(p1 + 3) == 38) && (*p1 == 39)) || ((*(p1 + 3) == 39) && (*p1 == 38)))// card 4 and 1
        ten1 = 1;
    else if(((*(p1 + 1) == 38) && (*(p1 + 4) == 39)) || ((*(p1 + 1) == 39) && (*(p1 + 4) == 38)))// card 2 and 5
       ten1 = 1;        
    
    //comparing player 10 of spades with 10 of clubs
    if(((*p1 == 39) && (*(p1 + 1) == 40)) || ((*p1 == 40) && (*(p1 + 1) == 39)))// card 1 and 2
        ten1 = 1;
    else if(((*(p1 + 1) == 39) && (*(p1 + 2) == 40)) || ((*(p1 + 1) == 40) && (*(p1 + 2) == 39)))// card 2 and 3
        ten1 = 1;
    else if(((*(p1 + 2) == 39) && (*(p1 + 3) == 40)) || ((*(p1 + 2) == 40) && (*(p1 + 3) == 39)))// card 3 and 4
        ten1 = 1;
    else if(((*(p1 + 3) == 39) && (*(p1 + 4) == 40)) || ((*(p1 + 3) == 40) && (*(p1 + 4) == 39)))// card 4 and 5
        ten1 = 1;
    else if(((*(p1 + 4) == 39) && (*p1 == 40)) || ((*(p1 + 4) == 40) && (*p1 == 39)))// card 5 and 1
        ten1 = 1;
    else if(((*(p1 + 1) == 39) && (*(p1 + 3) == 40)) || ((*(p1 + 1) == 40) && (*(p1 + 3) == 39)))// card 2 and 4
        ten1 = 1;
    else if(((*(p1 + 2) == 39) && (*p1 == 40)) || ((*(p1 + 2) == 40) && (*p1 == 39)))// card 3 and 1
        ten1 = 1;
    else if(((*(p1 + 2) == 39) && (*(p1 + 4) == 40)) || ((*(p1 + 2) == 40) && (*(p1 + 4) == 39)))// card 3 and 5
        ten1 = 1;
    else if(((*(p1 + 3) == 39) && (*p1 == 40)) || ((*(p1 + 3) == 40) && (*p1 == 39)))// card 4 and 1
        ten1 = 1;
    else if(((*(p1 + 1) == 39) && (*(p1 + 4) == 40)) || ((*(p1 + 1) == 40) && (*(p1 + 4) == 39)))// card 2 and 5
        ten1 = 1;

    //comparing player 10 of clubs with 10 of diamonds
    if(((*p1 == 37) && (*(p1 + 1) == 40)) || ((*p1 == 40) && (*(p1 + 1) == 37)))// card 1 and 2
        ten1 = 1;
    else if(((*(p1 + 1) == 37) && (*(p1 + 2) == 40)) || ((*(p1 + 1) == 40) && (*(p1 + 2) == 37)))// card 2 and 3
        ten1 = 1;
    else if(((*(p1 + 2) == 37) && (*(p1 + 3) == 40)) || ((*(p1 + 2) == 40) && (*(p1 + 3) == 37)))// card 3 and 4
        ten1 = 1;
    else if(((*(p1 + 3) == 37) && (*(p1 + 4) == 40)) || ((*(p1 + 3) == 40) && (*(p1 + 4) == 37)))// card 4 and 5
        ten1 = 1;
    else if(((*(p1 + 4) == 37) && (*p1 == 40)) || ((*(p1 + 4) == 40) && (*p1 == 37)))// card 5 and 1
        ten1 = 1;
    else if(((*(p1 + 1) == 37) && (*(p1 + 3) == 40)) || ((*(p1 + 1) == 40) && (*(p1 + 3) == 37)))// card 2 and 4
        ten1 = 1;
    else if(((*(p1 + 2) == 37) && (*p1 == 40)) || ((*(p1 + 2) == 40) && (*p1 == 37)))// card 3 and 1
        ten1 = 1;
    else if(((*(p1 + 2) == 37) && (*(p1 + 4) == 40)) || ((*(p1 + 2) == 40) && (*(p1 + 5) == 37)))// card 3 and 5
        ten1 = 1;
    else if(((*(p1 + 3) == 37) && (*p1 == 40)) || ((*(p1 + 3) == 40) && (*p1 == 37)))// card 4 and 1
        ten1 = 1;
    else if(((*(p1 + 1) == 37) && (*(p1 + 4) == 40)) || ((*(p1 + 1) == 40) && (*(p1 + 5) == 37)))// card 2 and 5
        ten1 = 1;
    
    //comparing player 10 of clubs with 10 of hearts
    if(((*p1 == 38) && (*(p1 + 1) == 40)) || ((*p1 == 40) && (*(p1 + 1) == 38)))// card 1 and 2
        ten1 = 1;
    else if(((*(p1 + 1) == 38) && (*(p1 + 2) == 40)) || ((*(p1 + 1) == 40) && (*(p1 + 2) == 38)))// card 2 and 3
        ten1 = 1;
    else if(((*(p1 + 2) == 38) && (*(p1 + 3) == 40)) || ((*(p1 + 2) == 40) && (*(p1 + 3) == 38)))// card 3 and 4
        ten1 = 1;
    else if(((*(p1 + 3) == 38) && (*(p1 + 4) == 40)) || ((*(p1 + 3) == 40) && (*(p1 + 4) == 38)))// card 4 and 5
        ten1 = 1;
    else if(((*(p1 + 4) == 38) && (*p1 == 40)) || ((*(p1 + 4) == 40) && (*p1 == 38)))// card 5 and 1
        ten1 = 1;
    else if(((*(p1 + 1) == 38) && (*(p1 + 3) == 40)) || ((*(p1 + 1) == 40) && (*(p1 + 3) == 38)))// card 2 and 4
        ten1 = 1;
    else if(((*(p1 + 2) == 38) && (*p1 == 40)) || ((*(p1 + 2) == 40) && (*p1 == 38)))// card 3 and 1
        ten1 = 1;
    else if(((*(p1 + 2) == 38) && (*(p1 + 4) == 40)) || ((*(p1 + 2) == 40) && (*(p1 + 4) == 38)))// card 3 and 5
        ten1 = 1;
    else if(((*(p1 + 3) == 38) && (*p1 == 40)) || ((*(p1 + 3) == 40) && (*p1 == 38)))// card 4 and 1
        ten1 = 1;
    else if(((*(p1 + 1) == 38) && (*(p1 + 4) == 40)) || ((*(p1 + 1) == 40) && (*(p1 + 4) == 38)))// card 2 and 5
        ten1 = 1;

    //comparing player A of diamonds with A of spades
    if(((*p1 == 37) && (*(p1 + 1) == 39)) || ((*p1 == 39) && (*(p1 + 1) == 37)))// card 1 and 2
        ten1 = 1;
    else if(((*(p1 + 1) == 37) && (*(p1 + 2) == 39)) || ((*(p1 + 1) == 39) && (*(p1 + 2) == 37)))// card 2 and 3
        ten1 = 1;
    else if(((*(p1 + 2) == 37) && (*(p1 + 3) == 39)) || ((*(p1 + 2) == 39) && (*(p1 + 3) == 37)))// card 3 and 4
        ten1 = 1;
    else if(((*(p1 + 3) == 37) && (*(p1 + 4) == 39)) || ((*(p1 + 3) == 39) && (*(p1 + 4) == 37)))// card 4 and 5
        ten1 = 1;
    else if(((*(p1 + 4) == 37) && (*p1 == 39)) || ((*(p1 + 4) == 39) && (*p1 == 37)))// card 5 and 1
        ten1 = 1;
    else if(((*(p1 + 1) == 37) && (*(p1 + 3) == 39)) || ((*(p1 + 1) == 39) && (*(p1 + 3) == 37)))// card 2 and 4
        ten1 = 1;
    else if(((*(p1 + 2) == 37) && (*p1 == 39)) || ((*(p1 + 2) == 39) && (*p1 == 37)))// card 3 and 1
        ten1 = 1;
    else if(((*(p1 + 2) == 37) && (*(p1 + 4) == 39)) || ((*(p1 + 2) == 39) && (*(p1 + 4) == 37)))// card 3 and 5
        ten1 = 1;
    else if(((*(p1 + 3) == 37) && (*p1 == 39)) || ((*(p1 + 3) == 39) && (*p1 == 37)))// card 4 and 1
        ten1 = 1;
    else if(((*(p1 + 1) == 37) && (*(p1 + 4) == 39)) || ((*(p1 + 1) == 39) && (*(p1 + 4) == 37)))// card 2 and 5
        ten1 = 1;
    
    //pair of 10s
    //comparing bot 10 of diamonds with 10 of hearts
    if(((*bot == 37) && (*(bot + 1) == 38)) || ((*bot == 38) && (*(bot + 1) == 37)))// card 1 and 2
        ten2 = 1;
    else if(((*(bot + 1) == 37) && (*(bot + 2) == 38)) || ((*(bot + 1) == 38) && (*(bot + 2) == 37)))// card 2 and 3
        ten2 = 1;
    else if(((*(bot + 2) == 37) && (*(bot + 3) == 38)) || ((*(bot + 2) == 38) && (*(bot + 3) == 37)))// card 3 and 4
        ten2 = 1;
    else if(((*(bot + 3) == 37) && (*(bot + 4) == 38)) || ((*(bot + 3) == 38) && (*(bot + 4) == 37)))// card 4 and 5
        ten2 = 1;
    else if(((*(bot + 4) == 37) && (*bot == 38)) || ((*(bot + 4) == 38) && (*bot == 37)))// card 5 and 1
        ten2 = 1;
    else if(((*(bot + 1) == 37) && (*(bot + 3) == 38)) || ((*(bot + 1) == 38) && (*(bot + 3) == 37)))// card 2 and 4
        ten2 = 1;
    else if(((*(bot + 2) == 37) && (*bot == 38)) || ((*(bot + 2) == 38) && (*bot == 37)))// card 3 and 1
        ten2 = 1;
    else if(((*(bot + 2) == 37) && (*(bot + 4) == 38)) || ((*(bot + 3) == 38) && (*(bot + 4) == 37)))// card 3 and 5
        ten2 = 1;
    else if(((*(bot + 3) == 37) && (*bot == 38)) || ((*(bot + 3) == 38) && (*bot == 37)))// card 4 and 1
        ten2 = 1;
    else if(((*(bot + 1) == 37) && (*(bot + 4) == 38)) || ((*(bot + 1) == 38) && (*(bot + 4) == 37)))// card 2 and 5
        ten2 = 1;

    //comparing player 10 of hearts with 10 of spades
    if(((*bot == 38) && (*(bot + 1) == 39)) || ((*bot == 39) && (*(bot + 1) == 38)))// card 1 and 2
        ten2 = 1;
    else if(((*(bot + 1) == 38) && (*(bot + 2) == 39)) || ((*(bot + 1) == 39) && (*(bot + 2) == 38)))// card 2 and 3
        ten2 = 1;
    else if(((*(bot + 2) == 38) && (*(bot + 3) == 39)) || ((*(bot + 2) == 39) && (*(bot + 3) == 38)))// card 3 and 4
        ten2 = 1;
    else if(((*(bot + 3) == 38) && (*(bot + 4) == 39)) || ((*(bot + 3) == 39) && (*(bot + 4) == 38)))// card 4 and 5
        ten2 = 1;
    else if(((*(bot + 4) == 38) && (*bot == 39)) || ((*(bot + 4) == 39) && (*bot == 38)))// card 5 and 1
        ten2 = 1;
    else if(((*(bot + 1) == 38) && (*(bot + 3) == 39)) || ((*(bot + 1) == 39) && (*(bot + 3) == 38)))// card 2 and 4
        ten2 = 1;
    else if(((*(bot+ 2) == 38) && (*bot == 39)) || ((*(bot + 2) == 39) && (*bot == 38)))// card 3 and 1
        ten2 = 1;
    else if(((*(bot + 3) == 38) && (*(bot + 4) == 39)) || ((*(bot + 3) == 39) && (*(bot + 4) == 38)))// card 3 and 5
        ten2 = 1;
    else if(((*(bot + 3) == 38) && (*bot == 39)) || ((*(bot + 3) == 39) && (*bot == 38)))// card 4 and 1
        ten2 = 1;
    else if(((*(bot + 1) == 38) && (*(bot + 4) == 39)) || ((*(bot + 1) == 39) && (*(bot + 4) == 38)))// card 2 and 5
        ten2 = 1;        
    
    //comparing player 10 of spades with 10 of clubs
    if(((*bot == 39) && (*(bot + 1) == 40)) || ((*bot == 40) && (*(bot + 1) == 39)))// card 1 and 2
        ten2 = 1;
    else if(((*(bot + 1) == 39) && (*(bot + 2) == 40)) || ((*(bot + 1) == 40) && (*(bot + 2) == 39)))// card 2 and 3
        ten2 = 1;
    else if(((*(bot + 2) == 39) && (*(bot + 3) == 40)) || ((*(bot + 2) == 40) && (*(bot + 3) == 39)))// card 3 and 4
        ten2 = 1;
    else if(((*(bot + 3) == 39) && (*(bot + 4) == 40)) || ((*(bot + 3) == 40) && (*(bot + 4) == 39)))// card 4 and 5
        ten2 = 1;
    else if(((*(bot + 4) == 39) && (*bot == 40)) || ((*(bot + 4) == 40) && (*bot == 39)))// card 5 and 1
        ten2 = 1;
    else if(((*(bot + 1) == 39) && (*(bot + 3) == 40)) || ((*(bot + 1) == 40) && (*(bot + 3) == 39)))// card 2 and 4
        ten2 = 1;
    else if(((*(bot + 2) == 39) && (*bot == 40)) || ((*(bot + 2) == 40) && (*bot == 39)))// card 3 and 1
        ten2 = 1;
    else if(((*(bot + 2) == 39) && (*(bot + 4) == 40)) || ((*(bot + 2) == 40) && (*(bot + 4) == 39)))// card 3 and 5
        ten2 = 1;
    else if(((*(bot + 3) == 39) && (*bot == 40)) || ((*(bot + 3) == 40) && (*bot == 39)))// card 4 and 1
        ten2 = 1;
    else if(((*(bot + 1) == 39) && (*(bot + 4) == 40)) || ((*(bot + 1) == 40) && (*(bot + 4) == 39)))// card 2 and 5
        ten2 = 1;

    //comparing player 10 of clubs with 10 of diamonds
    if(((*bot == 37) && (*(bot + 1) == 40)) || ((*bot == 40) && (*(bot + 1) == 37)))// card 1 and 2
        ten2 = 1;
    else if(((*(bot + 1) == 37) && (*(bot + 2) == 40)) || ((*(bot + 1) == 40) && (*(bot + 2) == 37)))// card 2 and 3
        ten2 = 1;
    else if(((*(bot + 2) == 37) && (*(bot + 3) == 40)) || ((*(bot + 2) == 40) && (*(bot + 3) == 37)))// card 3 and 4
        ten2 = 1;
    else if(((*(bot + 3) == 37) && (*(bot + 4) == 40)) || ((*(bot + 3) == 40) && (*(bot + 4) == 37)))// card 4 and 5
        ten2 = 1;
    else if(((*(bot + 4) == 37) && (*bot == 40)) || ((*(bot + 4) == 40) && (*bot == 37)))// card 5 and 1
        ten2 = 1;
    else if(((*(bot + 1) == 37) && (*(bot + 3) == 40)) || ((*(bot + 1) == 40) && (*(bot + 3) == 37)))// card 2 and 4
        ten2 = 1;
    else if(((*(bot + 2) == 37) && (*bot == 40)) || ((*(bot + 2) == 40) && (*bot == 37)))// card 3 and 1
        ten2 = 1;
    else if(((*(bot + 2) == 37) && (*(bot + 4) == 40)) || ((*(bot + 2) == 40) && (*(bot + 5) == 37)))// card 3 and 5
        ten2 = 1;
    else if(((*(bot + 3) == 37) && (*bot == 40)) || ((*(bot + 3) == 40) && (*bot == 37)))// card 4 and 1
        ten2 = 1;
    else if(((*(bot + 1) == 37) && (*(bot + 4) == 40)) || ((*(bot + 1) == 40) && (*(bot + 5) == 37)))// card 2 and 5
        ten2 = 1;
    
    //comparing player 10 of clubs with 10 of hearts
    if(((*bot == 38) && (*(bot + 1) == 40)) || ((*bot == 40) && (*(bot + 1) == 38)))// card 1 and 2
        ten2 = 1;
    else if(((*(bot + 1) == 38) && (*(bot + 2) == 40)) || ((*(bot + 1) == 40) && (*(bot + 2) == 38)))// card 2 and 3
        ten2 = 1;
    else if(((*(bot + 2) == 38) && (*(bot + 3) == 40)) || ((*(bot + 2) == 40) && (*(bot + 3) == 38)))// card 3 and 4
        ten2 = 1;
    else if(((*(bot + 3) == 38) && (*(bot + 4) == 40)) || ((*(bot + 3) == 40) && (*(bot + 4) == 38)))// card 4 and 5
        ten2 = 1;
    else if(((*(bot + 4) == 38) && (*bot == 40)) || ((*(bot + 4) == 40) && (*bot == 38)))// card 5 and 1
        ten2 = 1;
    else if(((*(bot + 1) == 38) && (*(bot + 3) == 40)) || ((*(bot + 1) == 40) && (*(bot + 3) == 38)))// card 2 and 4
        ten2 = 1;
    else if(((*(bot + 2) == 38) && (*bot == 40)) || ((*(bot + 2) == 40) && (*bot == 38)))// card 3 and 1
        ten2 = 1;
    else if(((*(bot + 2) == 38) && (*(bot + 4) == 40)) || ((*(bot + 2) == 40) && (*(bot + 4) == 38)))// card 3 and 5
        ten2 = 1;
    else if(((*(bot + 3) == 38) && (*bot == 40)) || ((*(bot + 3) == 40) && (*bot == 38)))// card 4 and 1
        ten2 = 1;
    else if(((*(bot + 1) == 38) && (*(bot + 4) == 40)) || ((*(bot + 1) == 40) && (*(bot + 4) == 38)))// card 2 and 5
        ten2 = 1;

    //comparing player A of diamonds with A of spades
    if(((*bot == 37) && (*(bot + 1) == 39)) || ((*bot == 39) && (*(bot + 1) == 37)))// card 1 and 2
        ten2 = 1;
    else if(((*(bot + 1) == 37) && (*(bot + 2) == 39)) || ((*(bot + 1) == 39) && (*(bot + 2) == 37)))// card 2 and 3
        ten2 = 1;
    else if(((*(bot + 2) == 37) && (*(bot + 3) == 39)) || ((*(bot + 2) == 39) && (*(bot + 3) == 37)))// card 3 and 4
        ten2 = 1;
    else if(((*(bot + 3) == 37) && (*(bot + 4) == 39)) || ((*(bot + 3) == 39) && (*(bot + 4) == 37)))// card 4 and 5
        ten2 = 1;
    else if(((*(bot + 4) == 37) && (*bot == 39)) || ((*(bot + 4) == 39) && (*bot == 37)))// card 5 and 1
        ten2 = 1;
    else if(((*(bot + 1) == 37) && (*(bot + 3) == 39)) || ((*(bot + 1) == 39) && (*(bot + 3) == 37)))// card 2 and 4
        ten2 = 1;
    else if(((*(bot + 2) == 37) && (*bot == 39)) || ((*(bot + 2) == 39) && (*bot == 37)))// card 3 and 1
        ten2 = 1;
    else if(((*(bot + 2) == 37) && (*(bot + 4) == 39)) || ((*(bot + 2) == 39) && (*(bot + 4) == 37)))// card 3 and 5
        ten2 = 1;
    else if(((*(bot + 3) == 37) && (*bot == 39)) || ((*(bot + 3) == 39) && (*bot == 37)))// card 4 and 1
        ten2 = 1;
    else if(((*(bot + 1) == 37) && (*(bot + 4) == 39)) || ((*(bot + 1) == 39) && (*(bot + 4) == 37)))// card 2 and 5
        ten2 = 1;
    
    //HIGH CARD
    //comparing player
    if((*p1 > *(p1 + 1)) && (*p1 > *(p1 + 2)) && (*p1 > *(p1 + 3)) && (*p1 > *(p1 + 4)))
        biggest1 = *p1;
    else if((*(p1 + 1) > *p1) && (*(p1 + 1) > *(p1 + 2)) && (*(p1 + 1) > *(p1 + 3)) && (*(p1 + 1) > *(p1 + 4)))
        biggest1 = *(p1 + 1);
    else if((*(p1 + 2) > *(p1 + 1)) && (*p1 < *(p1 + 2)) && (*(p1 + 2) > *(p1 + 3)) && (*(p1 + 2) > *(p1 + 4)))
        biggest1 = *(p1 + 2);
    else if((*(p1 + 3) > *(p1 + 1)) && (*(p1 + 3) > *(p1 + 2)) && (*p1 < *(p1 + 3)) && (*(p1 + 3) > *(p1 + 4)))
        biggest1 = *(p1 + 3);
    else if((*(p1 + 4) > *(p1 + 1)) && (*(p1 + 4) > *(p1 + 2)) && (*(p1 + 4) > *(p1 + 3)) && (*p1 < *(p1 + 4)))
        biggest1 = *(p1 + 4);
        
    //comparing BOT
    if((*bot > *(bot + 1)) && (*bot > *(bot + 2)) && (*bot > *(bot + 3)) && (*bot > *(bot + 4)))
        biggest2 = *bot;
    else if((*(bot + 1) > *bot) && (*(bot + 1) > *(bot + 2)) && (*(bot + 1) > *(bot + 3)) && (*(bot + 1) > *(bot + 4)))
        biggest2 = *(bot + 1);
    else if((*(bot + 2) > *(bot + 1)) && (*bot < *(bot + 2)) && (*(bot + 2) > *(bot + 3)) && (*(bot + 2) > *(bot + 4)))
        biggest2 = *(bot + 2);
    else if((*(bot + 3) > *(bot + 1)) && (*(bot + 3) > *(bot + 2)) && (*bot < *(bot + 3)) && (*(bot + 3) > *(bot + 4)))
        biggest2 = *(bot + 3);
    else if((*(bot + 4) > *(bot + 1)) && (*(bot + 4) > *(bot + 2)) && (*(bot + 4) > *(bot + 3)) && (*bot < *(bot + 4)))
        biggest2 = *(bot + 4);

    if(as1 == 1)
        return 1;
    else if(as2 == 1)
        return 2;
    else if(ten1 == 1)
        return 3;
    else if(ten2 == 1)
        return 4;
    else if(biggest1 > biggest2)
        return 5;
    else
        return 6;
}

//Of course, main function
int main()
{
    //Variables
    const int car1 = 26, car2 = 26, win1 = 5, win2 = 5;
    int p1[car1], p2[car2], w1[win1], w2[win2], coins = 0, a = 0, b = 5, coins1 = 0, coins2 = 0, stack = 0, r = 0, l = 0;
    string player;
    char playerD, playerP, playerB;
    bool game = true, exit = true, swap = true, decisionA = true, decisionB = true;
    ifstream irecord;
    ofstream orecord;

    //Vector
    vector <int> scores;

    //Main menu
    cout << "Hello! First of all let's start with your name:" << endl;

    //get line if a player wants to use surname
    getline(cin, player);

    //The purpose of this while loop is to make sure that the player is going to put the correct value
    while(game)
    {
        //Exit condition
        exit = true;

        //Welcome Message and displaying the options to the player
        cout << "Welcome to C-poker " << player << " ! Now tell me, what you want to do? " << endl;
        cout << "Press P if you want to play the game.\nPress R if you want to read the instructions\n"
        "Press L if you want to check the Leaderboard\nPress E if you want to exit." << endl;

        //Player Input
        cin >> playerD;

        //Play game
        if((playerD == 'p') || (playerD == 'P'))
        {
            cout << "Lets play the game!" << endl;
            //Coins!
            coins = 200000;
            stack = 0;

            //Conditions
            r = 0;
            //This loop is to reapeat the game 3 times
            while(r < 3)
            {
                //Calling the function to shuffle and give
                shuffleGive(p1,p2);

                //Start coins
                coins = coins - 20000;
                stack = stack + 20000;

                //Conditions
                swap = true;
                decisionA = true;
                decisionB = true;

                //loop to swap the card until the player decides to play
                while(swap)
                {
                    //Printing cards
                    cout << "Your coins: " << coins << endl;
                    cout << "Your cards:" << endl;
                    while(a < b)
                    {
                        //Loop to give an impression that the dealer is giving the cards
                        for(int d = 0; d < 10000000; d++)
                        {
                            cout << "";
                        }
                        printCard(&p1[a]);
                        cout << "" << endl;
                        a++;
                    }

                    cout << "" << endl;//Skipping line

                    //While if the user puts the wrong letter
                    decisionA = true;
                    while(decisionA)
                    {
                        //Decision Message
                        cout << "what you want to do?" << endl;
                        cout << "If you want to swap the cards s\nIf you want to stand press k." << endl;

                        //Player Input
                        cin >> playerP;
                        if((playerP == 'k') || (playerP == 'K'))//If player to keep the cards
                        {
                            //While if the user puts a wrong letter
                            decisionB = true;
                            while(decisionB)
                            {
                                cout << "You stood! Now you want to double your bet or keep: " << stack << endl;
                                cout << "Press k if you want to keep." << endl;
                                cout << "Press d if want to double press d." << endl;

                                cin >> playerB;

                                //Decision
                                if((playerB == 'd') || (playerB == 'D'))
                                {
                                    stack = stack * 2;
                                    cout << "Ok! you want double, You are putting: " << stack << endl;
                                    stack = stack * 2;
                                    cout << "Now this match values: " << stack << endl;
                                    playerB = 'k';
                                }
                                if((playerB == 'k') || (playerB == 'K'))
                                {
                                    cout << "Ok! Now show me your cards." << endl;
                                    a = a - 5;
                                    
                                    //Player Cards
                                    for(int c = 0; c < 5; c++)
                                    {
                                        printCard(&p1[a]);
                                        cout << " ";
                                        a++;
                                    }
                                    
                                    cout << "" << endl;//Skipping line
                                    cout << "Bot Cards:" << endl;
                                    //Bot Cards
                                    for(int d = 0; d < 5; d++)
                                    {
                                        //Loop to give emotion of the bot showing its cards
                                        for(int d = 0; d < 10000000; d++)
                                        {
                                            cout << "";
                                        }
                                        printCard(&p2[d]);
                                        cout << "" << endl;
                                    }

                                    //Loop to give a time for the player to compare the cards
                                    //giving a time to check
                                    for(int d = 0; d < 50000000; d++)
                                        {
                                            cout << "";
                                        }

                                    //Winning Condition
                                    //passing both player player cards to the winning condition
                                    a = a - 5;//This formula is to send the 5 cards of the player
                                    
                                    //passing the player cards.
                                    for(int e = 0; e < 5; e++)
                                    {
                                        w1[e] = p1[a];
                                        a++;
                                    }

                                    //passing the bot cards.
                                    for(int f = 0; f < 5; f++)
                                    {
                                        w2[f] = p2[f];
                                    }

                                    //line
                                    cout << "" << endl;

                                    if(winningCondition(w1, w2) == 1)
                                    {
                                        cout << "Player wins. With a pair of AS." << endl;
                                        cout << "Congratulations! " << player << ", you won: " << stack << endl;
                                        if(stack == 20000)
                                            stack = stack + 20000;
                                        coins = coins + stack;
                                    }
                                    else if(winningCondition(w1, w2) == 2)
                                    {
                                        cout << "Bot wins. With a pair of AS." << endl;
                                        if(stack > 20000)
                                            stack = stack / 2;
                                        cout << player << ", you lose: " << stack << endl;
                                        coins = coins - stack;
                                    }

                                    else if(winningCondition(w1, w2) == 3)
                                    {
                                        cout << "Player wins. With pair of 10s." << endl;
                                        cout << "Congratulations! " << player << ", you won: " << stack << endl;
                                        if(stack == 20000)
                                            stack = stack + 20000;
                                        coins = coins + stack;
                                    }

                                    else if(winningCondition(w1, w2) == 4)
                                    {
                                        cout << "bot wins. With pair of 10s." << endl;
                                        if(stack > 20000)
                                            stack = stack / 2;
                                        cout << player << ", you lose: " << stack << endl;
                                        coins = coins - stack;
                                    }
                                    
                                    else if(winningCondition(w1, w2) == 5)
                                    {
                                        cout << "Player wins. With high card." << endl;
                                        cout << "Congratulations! " << player << ", you won: " << stack << endl;
                                        if(stack == 20000)
                                            stack = stack + 20000;
                                        coins = coins + stack;
                                    }
                                    
                                    else if(winningCondition(w1, w2) == 6)
                                    {
                                        cout << "bot wins. With high card." << endl;
                                        if(stack > 20000)
                                            stack = stack / 2;
                                        cout << player << ", you lose: " << stack << endl;
                                        coins = coins - stack;
                                    }

                                    //giving a time to check
                                    for(int d = 0; d < 100000000; d++)
                                        {
                                            cout << "";
                                        }

                                    //Leaving the loops
                                    decisionB = false;
                                    decisionA = false;
                                    swap = false;

                                    //Reseting the cards
                                    b = 5;
                                    a = 0;

                                    //Reseting the stack
                                    stack = 0;
                                }
                                else
                                {
                                    cout << "Invalid entry." << endl;
                                }
                            }
                        }
                        else if((playerP == 's') || (playerP == 'S'))//If player wants to swap
                        {
                            coins = coins - 2500;
                            b = b + 5;
                            swap = true;
                            decisionA = false;

                            //an if statement to restart if the player keep swapping
                            if(b > 25)
                            {
                                b = 5;
                                a = 0;
                            }
                        }
                        else
                        {
                            cout << "invalid entry, try again" << endl;
                            decisionA = true;
                        }
                    }
                }
                r++;
            }
            cout << "Your total score: " << coins << endl;

            //recording the record in the leaderboard
            if(coins > 160000)
            {
                scores.push_back(coins);
                cout << "Congratulations! You are going to the leaderboard." << endl;
                l = 1;
            }

            cout << "" << endl;
            cout << "Thanks for playing!" << endl;
            cout << "" << endl;
            //giving a time to check
            for(int d = 0; d < 20000000; d++)
            {
                cout << "";
            }
        }
        //Rules
        else if((playerD == 'r') || (playerD == 'R'))
        {
            //Variables
            string read;
            ifstream file;

            //Read Instructions(using File to print out the rules)
            file.open("rules.txt");

            while(file.good())
            {
                getline(file, read);

                cout << read << endl;
            }

            file.close();
            //Giving a line
            cout << "" << endl;
            
            //Giving a time for the user to read the rules.
            for(int d = 0; d < 49000000; d++)
            {
                cout << "";
            }
        }
        //LearderBoard
        else if((playerD == 'l') || (playerD == 'L'))
        {
            //variables
            int record = 0;
            int count = 0;

            //skipping line
            cout << "" << endl;

            cout << "Leaderboard:" << endl;

            //adding to the vector
            //First Records
            scores.push_back(160000);
            scores.push_back(150000);
            
            //Printing out the leaderboard
            for(int i = 0; i < scores.size(); i++)
            {
                if(i == 0)
                    cout << "" << endl;
                    if(l == 1)
                    {
                        cout << player << " - " << scores.at(i) << endl;
                        l = 0;
                    }
                else if(i == 1)
                    cout << "Mary - " << scores.at(i) << endl;
                else
                cout << "Mike - " << scores.at(i) << endl;
            }
            
            //Erasing vector to not repeat after the while loop is activated
            scores.clear();

            //skipping line
            cout << "" << endl;
        }
        //Quitting
        else if((playerD == 'e') || (playerD == 'E'))
        {
            while(exit)
            {
                cout << "Are you sure you want to exit? (Y = yes / N = no)" << endl;
                cin >> playerD;
                if((playerD == 'Y') || (playerD == 'y'))
                {
                    //Quit
                    game = false;
                    exit = false;
                }
                else if((playerD == 'N') || (playerD == 'n'))
                {
                    //Back to the game
                    game = true;
                    exit = false;
                }
                else
                {
                    //giving a delay if a user make a mistake
                    for(int d = 0; d < 10000000; d++)
                    {
                        cout << "";
                    }
                    cout << "Invalid entry. Y (Yes) if you want to leave or N (No) if you wanna keep playing." << endl;
                    exit = true;
                }
            }
        }
        else
        {
            //giving a delay if a user make a mistake
            for(int d = 0; d < 10000000; d++)
            {
                cout << "";
            }

            cout << "" << endl;//skipping line
            cout << "Invalid entry, please try again." << endl;
            cout << "" << endl;//skipping line
        }

        //clearing the last input
        cin.clear();
        //ignoring previous input
        cin.ignore(100, '\n');
    }

    cout << "Thank you! Come back anytime." << endl;
    return 0;
}