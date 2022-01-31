INSERT INTO `disciplina`(`nome`, `descricao`) VALUES ('Matemática', 'Descrição 01');
INSERT INTO `disciplina`(`nome`, `descricao`) VALUES ('História', 'Descrição 01');
INSERT INTO `disciplina`(`nome`, `descricao`) VALUES ('Geografia', 'Descrição 01');
INSERT INTO `disciplina`(`nome`, `descricao`) VALUES ('Física', 'Descrição 01');
INSERT INTO `disciplina`(`nome`, `descricao`) VALUES ('Biologia', 'Descrição 01');
INSERT INTO `disciplina`(`nome`, `descricao`) VALUES ('Português', 'Descrição 01');

INSERT INTO `aluno` (`nome`, `email`, `telefone`, `cpf`) VALUES  ('João Carlos', 'joao@gmail.com', '84991800002', '216.747.480-60');
INSERT INTO `aluno` (`nome`, `email`, `telefone`, `cpf`) VALUES  ('Leonardo Silva', 'leo@gmail.com', '84991800002', '481.473.250-37');
INSERT INTO `aluno` (`nome`, `email`, `telefone`, `cpf`) VALUES  ('Maria Silva', 'maria@gmail.com', '84991800002', '121.026.180-48');

INSERT INTO `professor` (`nome`, `email`, `telefone`, `cpf`) VALUES  ('Ruan Gabriel', 'ruan@gmail.com', '84991800002', '365.910.750-62');
INSERT INTO `professor` (`nome`, `email`, `telefone`, `cpf`) VALUES  ('Júlia Santos', 'julia@gmail.com', '84991800002', '666.301.300-90');
INSERT INTO `professor` (`nome`, `email`, `telefone`, `cpf`) VALUES  ('Eduarda Costa', 'edu@gmail.com', '84991800002', '259.272.150-92');

INSERT INTO `disciplina_aluno` (`disciplina_id`, `aluno_id`) values  (1, 1);
INSERT INTO `disciplina_aluno` (`disciplina_id`, `aluno_id`) values  (1, 2);
INSERT INTO `disciplina_aluno` (`disciplina_id`, `aluno_id`) values  (1, 3);