 DECLARE @return_code int  
 EXEC @return_code = [dbo].[insert_part]	
	 @ID = '3',
	 @part_name = 'tube',
	 @part_length = '1.66'   ,
	 @demagnetization = 'true' 
 SELECT @return_code
