import {useState} from "react";

function AddTask() {
    const [taskTitle, setTaskTitle] = useState("")
    const [taskDescription, setTaskDescription] = useState("")
    const [taskStatus, setTaskStatus] = useState("")

    const handleSubmitTask = async() => {
        const response = await fetch("http://localhost:8080/api/tasks", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                description: taskDescription,
                title: taskTitle,
                status: taskStatus
            }),
        })

        const data = await response.json()

        console.log(data)
    }

    return (
        <>
            <h1>Create a Task</h1>
            <form>
                <input
                    type="text"
                    onChange={e => setTaskTitle(e.target.value)}
                    value={taskTitle}
                    placeholder="Task title" /> <br/>
                <input
                    type="text"
                    onChange={e => setTaskDescription(e.target.value)}
                    value={taskDescription}
                    placeholder="Task description" /> <br/>
                <input
                    type="text"
                    onChange={e => setTaskStatus(e.target.value)}
                    value={taskStatus}
                    placeholder="Task status" /> <br/>
                <button onClick={handleSubmitTask}>Add task</button>
            </form>
        </>
    )
}

export default AddTask