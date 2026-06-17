import {useEffect, useState} from "react";
import Task from "../Task/Task.tsx";

function GetTasks() {
    const [tasks, setTasks] = useState([])

    const getAllTasksHandler = async() => {
        const response = await fetch("http://localhost:8080/api/tasks/all");

        const data = await response.json()

        setTasks(data)
    }

    useEffect(() => {
        getAllTasksHandler()
    }, [])


    return(
        <>
            <h1>Tasks</h1>
            {tasks.map(task => (
                <div>
                    <Task task={task}/>
                </div>
            ))}
        </>
    )
}

export default GetTasks;