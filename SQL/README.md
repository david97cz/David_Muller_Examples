# Example of SQL stored procedures

Table for sotring parts has 4 columns - id (primary key), part_name (string), part_length (real) and demagnetization (booloean)

Inserting procedure will update existing row, if the 'id' is already created

Deleteng procedure deletes rows with seleted id from all tables - it needs to ben done as a transaction
