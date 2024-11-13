CREATE MATERIALIZED VIEW tasks_per_project as
SELECT  "project_id", count(*) as tasks_count
FROM tasks
GROUP BY project_id