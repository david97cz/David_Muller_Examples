USE [TEST]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[insert_part]	
	@id int,
	@part_name nvarchar(50),
	@part_length float,
	@demagnetization bit
AS

DECLARE @id_count int;

BEGIN
--chceck if ID exists
SET @id_count = (SELECT COUNT(*) 
				FROM [dbo].[table_parts]
				WHERE [id] = @id);

-- if ID exists -> update
IF (@id_count > 0) BEGIN TRY
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


ELSE
	BEGIN TRY

	SET NOCOUNT ON;
	-- nocount must be on or some error in controlweb can occur
	SET @id = next value for [dbo].[sqc_new_id]
	INSERT INTO [dbo].[table_parts]
				([id]
				,[part_name]
				,[part_length]
				,[demagnetization])

				VALUES
				(@id,
				@part_name,
				@part_length,
				@demagnetization)

			RETURN 2;
	END TRY
	BEGIN CATCH
		RETURN 9
	END CATCH
END
