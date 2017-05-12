# kbsearch
Knowledge Base Search Application

# Steps in Search
### 1. Tokenize Search Phrase
**Input:** "How do I pay my bill online online?"

**Output:** ["how","do","i","pay","my","bill","online"]

- Extract the tokens from the search phrase
- Convert all the tokens to lowercase
- Each token should be unique 
- Remove special characters and punctuations (, #, ?, /, ., etc.)

### 2. Remove Ignore words from the tokens
Remove the irrelevant words from the list of tokens

**Input:** ["how","do","i","pay","my","bill","online"]

**Output:** ["pay","bill","online"]

### 3. Search All Topics
Search a list of all topics to locate keywords. If keyword is found, add the topic to search result.

