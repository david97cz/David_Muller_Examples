 DECLARE @return_code int  
 EXEC @return_code = dbo.delete_part    
 @id = '3' 
 SELECT @return_code 
