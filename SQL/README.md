# Example of SQL stored procedures

Table for sotring parts has 4 columns - id (primary key), part_name (string), part_length (real) and demagnetization (booloean)

Inserting procedure will update existing row, if the 'id' is already created

Deleting procedure deletes rows with seleted id from all tables - it needs to ben done as a transaction

```sql
BEGIN TRANSACTION update_part
	
	SET NOCOUNT ON;
	-- nocount must be on or some error in controlweb can occur
	UPDATE [dbo].[table_parts]
	SET

		[part_name] = @part_name,
		[part_length] = @part_length,
		[demagnetization] = @demagnetization
		WHERE [id] = @id;
	COMMIT TRANSACTION update_part

	RETURN 1;

	END TRY

	BEGIN CATCH
	ROLLBACK TRANSACTION update_part
	RETURN 8;
	END CATCH
```
