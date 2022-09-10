# InterviewDeck
InterviewDeck for Interview experiences and Interview Mentors





1. JWT (Ajay)
2. Search API (Get deck) (Ajay)
3. GetDeck (by user, by company) (Venkat)
4. Put(update) deck api (Venkat)



frontend: (Samruddha)
1. search api:
    1. need to provide a search bar with button and a filter for company.
    2. in the search response will get top 10 searches (deck id + deckcontent)
    3. on click of any of the link, the deck will be shown to user.

2. For deck page:
    1. edit button  will be available.
    2. edit will work exactly like the create new form, just the data which is available, will be populated
    into the fields of the form
    3. upon click of save, all the data needs to be sent to backend api.


2. updating deck: for cases:
    1. adding new record: record json without any id will be sent.
    2. updating: just the record will be updated.
    3. deleting: the respective record id will remain intact, and all other fields must be removed.




Remaining:
    1. Signup (auth or our own token)
    2. profile of user. (CRUD)
