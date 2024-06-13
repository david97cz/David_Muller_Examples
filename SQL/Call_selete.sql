 DECLARE @return_code int  
 EXEC @return_code = dbo.delete_part    
 @id = '2' 
 SELECT @return_code 
