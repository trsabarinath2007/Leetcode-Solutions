/**select patient_id , Patient_name,conditions
from patients
where conditions regexp '(^| )DIAB1';**/

select patient_id , Patient_name,conditions
from patients
where conditions like 'DIAB1%' or conditions like '% DIAB1%';