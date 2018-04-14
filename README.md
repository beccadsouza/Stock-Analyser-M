# Stock-Analyser-M
Middle ware for Stock Analyser

Objective -
Build a service which can process historical shareholding information of companies to come up with interesting analytics.
 
Details -
A common dilemma facing private equity investors is to decide which companies to invest in. One of the best ways to learn is by mimicking the experts.
There are different regulations in different countries which mandate large shareholders to declare their holdings. SEBI mandates that each publicly listed company should disclose the name of all individuals / companies that hold more than 1% stake. US has a similar guideline where investors with more than 100m $ investment have to publicly disclose their holdings.
These kind of information can serve as a valuable learning experience for other investors.
The aim of this project is to build a system which allows an individual to analyse and consume this kind of a data in a well represented, concise and user-friendly form.
 
Tasks -
1. Design a database schema to hold investment holding data of companies.
2. Source publicly available investment holding data.
3. Design and develop a service to access, analyze and process this data.
4. Design and develop a User Interface to allow users to interact with this data.
5. Develop various analytics based on this data. (Analytics described below)
6. Provide API to interact with Pricing Project / Portfolio Management Project / News Analyzer project to create a unified interface.
 
Analytics -
1. Sector based holding trends.
-- Data of all investors, which sector grew and which came down over a period
2. Company based holding trends.
-- Data of all investors, which company holding grew and which came down over a period
3. Holding & Market Share.
-- For each company, which investor has how much and what is it's share over total market cap.
4. Market Value over time.
-- Data of all investors, what is the market value. Ability to filter down to company, sector, period.
5. Heat Map of sector
-- Data of all investors, in various periods.
6. Heat Map of companies
-- Data of all investors, in various periods.
 
Out of scope -
Machine learning algorithms.
-- Focus is on system design and architecture. Build simple data based analytics.
 
Additional Information -
- US big investor holding data of past year is freely available. Visit www.whalewisdom.com for API to use to extract that data.

