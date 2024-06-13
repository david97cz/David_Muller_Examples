SELECT [id]
      ,[part_name]
      ,[part_length]
      ,[demagnetization]
FROM [dbo].[table_parts]

--filters all records tarted with tube
WHERE [part_name] like 'tube%'
ORDER BY [part_name]
