use test;
alter table projects add column cost double;
UPDATE projects SET cost = 7600 WHERE (id = 1);
UPDATE projects SET cost = 4400 WHERE (id = 2);
UPDATE projects SET cost = 4900 WHERE (id = 3);
UPDATE projects SET cost = 7700 WHERE (id = 4);
UPDATE projects SET cost = 3600 WHERE (id = 5);