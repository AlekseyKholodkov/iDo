DROP TABLE IF EXISTS tasks;

  /*Hibernate*/
CREATE TABLE IF NOT EXISTS tasks
(
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  state VARCHAR(20),
  task VARCHAR(255),
  superTask_id BIGINT,
  FOREIGN KEY (supertask_id) REFERENCES tasks (id)
);
CREATE INDEX tasks_superTask ON tasks (superTask_id);

--  DROP SEQUENCE IF EXISTS seq;
-- CREATE SEQUENCE IF NOT EXISTS seq;

-- -- H2 SysProperties. Settings Read from System Properties
-- SELECT * FROM INFORMATION_SCHEMA.SETTINGS;

