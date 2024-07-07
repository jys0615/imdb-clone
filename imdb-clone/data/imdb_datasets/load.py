import pandas as pd
from sqlalchemy import create_engine

# Define the file paths
title_basics_path = r'C:\Users\Admin\OneDrive\Desktop\Spring\imdb-clone\data\imdb_datasets\title.basics.tsv'
title_akas_path = r'C:\Users\Admin\OneDrive\Desktop\Spring\imdb-clone\data\imdb_datasets\title.akas.tsv'
name_basics_path = r'C:\Users\Admin\OneDrive\Desktop\Spring\imdb-clone\data\imdb_datasets\name.basics.tsv'
title_principals_path = r'C:\Users\Admin\OneDrive\Desktop\Spring\imdb-clone\data\imdb_datasets\title.principals.tsv'

# Database connection string
DATABASE_URI = 'mysql+pymysql://root:123456@localhost:3306/imdb_clone'

# Create a database engine
engine = create_engine(DATABASE_URI)

# Load Movies
title_basics_df = pd.read_csv(title_basics_path, sep='\t', low_memory=False)
movies = title_basics_df[['tconst', 'primaryTitle', 'startYear']]
movies.columns = ['id', 'title', 'production_year']
movies = movies.dropna(subset=['id', 'title', 'production_year'])
movies.to_sql('movie', con=engine, if_exists='append', index=False)

# Load Genres
genres_df = pd.read_csv(title_akas_path, sep='\t', low_memory=False)
genres = genres_df[['titleId', 'region']].drop_duplicates()
genres.columns = ['id', 'name']
genres.to_sql('genre', con=engine, if_exists='append', index=False)

# Load Persons
name_basics_df = pd.read_csv(name_basics_path, sep='\t', low_memory=False)
persons = name_basics_df[['nconst', 'primaryName', 'birthYear', 'deathYear', 'primaryProfession']]
persons.columns = ['id', 'name', 'birth_year', 'death_year', 'gender']
persons.to_sql('person', con=engine, if_exists='append', index=False)

# Load Roles
roles = pd.DataFrame({
    'id': [1, 2, 3],
    'name': ['Actor', 'Actress', 'Director']
})
roles.to_sql('role', con=engine, if_exists='append', index=False)

# Load CastInfo
title_principals_df = pd.read_csv(title_principals_path, sep='\t', low_memory=False)
cast_info = title_principals_df[['tconst', 'nconst', 'category']]
cast_info.columns = ['movie_id', 'person_id', 'role']
cast_info.to_sql('cast_info', con=engine, if_exists='append', index=False)
