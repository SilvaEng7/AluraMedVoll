-- 1. Garante que todos os registros atuais tenham o valor 1
<<<<<<< HEAD
=======
ALTER TABLE medicos ADD ativo tinyint;
ALTER TABLE pacientes ADD ativo tinyint;

>>>>>>> developer
UPDATE pacientes SET ativo = 1 WHERE ativo IS NULL;
UPDATE medicos SET ativo = 1 WHERE ativo IS NULL;

-- 2. Aplica a obrigatoriedade (NOT NULL)
ALTER TABLE pacientes MODIFY COLUMN ativo TINYINT NOT NULL;
ALTER TABLE medicos MODIFY COLUMN ativo TINYINT NOT NULL;