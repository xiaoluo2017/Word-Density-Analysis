# Word-Density-Analysis
Given any page (URL), classify the page, and return a list of relevant topics.



# Dependencies
<dependencies>
    <dependency>
        <!-- jsoup HTML parser library @ http://jsoup.org/ -->
        <groupId>org.jsoup</groupId>
        <artifactId>jsoup</artifactId>
        <version>1.10.2</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/edu.stanford.nlp/stanford-corenlp -->
    <dependency>
        <groupId>edu.stanford.nlp</groupId>
        <artifactId>stanford-corenlp</artifactId>
        <version>3.8.0</version>
    </dependency>
    <dependency>
        <groupId>edu.stanford.nlp</groupId>
        <artifactId>stanford-corenlp</artifactId>
        <version>3.8.0</version>
        <classifier>models</classifier>
    </dependency>
</dependencies>

# Design
Used jsoup to crawl url to get the original data. 
Used Stanford CoreNLP to lemmatize the original data and remove stopwords by check whether in stopwords.txt 
Stored the new data in HashMap, key is the word, value is number it appears. 
Used PriorityQueue to get the K most common keywords from the HashMap.

# Test Cases
http://www.amazon.com/Cuisinart-CPT-122-Compact-2-Slice-Toaster/dp/B009GQ034C/ref=sr_1_1?s=kitchen&ie=UTF8&qid=1431620315&sr=1-1&keywords=toaster
http://blog.rei.com/camp/how-to-introduce-your-indoorsy-friend-to-the-outdoors/
http://www.cnn.com/2013/06/10/politics/edward-snowden-profile/
Assume keywordNumber is 5.
For 1st url, the output is toast 64, toaster 62, 5 62, bread 46, Amazon 45
For 2nd url, the output is friend 15, like 5, time 5, take 5, keep 5
For 3rd url, the output is NSA 16, watch 14, Snowden 14, say 13, government 8

# Reference
Stanford CoreNLP: https://stanfordnlp.github.io/CoreNLP/simple.html
Stopwords: https://github.com/stanfordnlp/CoreNLP/blob/master/data/edu/stanford/nlp/patterns/surface/stopwords.txt
