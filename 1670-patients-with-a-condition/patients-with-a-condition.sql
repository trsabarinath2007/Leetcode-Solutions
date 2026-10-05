select patient_id , Patient_name,conditions
from patients
where conditions regexp '(^| )DIAB1';