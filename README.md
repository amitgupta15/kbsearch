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

### 3. Run a spell check on tokens

**Input:** ["pey","bill","online"]

**Output:** ["pey","pay","bill","online"]

- Run all the tokens through dictionary and separate out the ones that are not in the dictionary: ["pey"]
- Run the separated tokens through jaro winkler algo to find a possible match in the dictionary: ["pay"]
- If match is found, add that word in the list of tokens

### 4. Run the tokens through context map

**Input:** ["contact"]

**Output:** ["contact","facebook","mail","fax","phone"]

- Run all the relevant tokens through context map to find contextual references
- If match is found, add all the contextual tokens to the list of tokens

### 5. Search All Topics
Search a list of all topics to locate keywords. If keyword is found, add the topic to search result.

**Input:** "How do I pay my bill online?"

**Output:** ["Can I pay my bill online?", "How can I get help paying my bill?"]

