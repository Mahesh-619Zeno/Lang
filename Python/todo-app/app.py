from flask import Flask, request, jsonify
from flask_cors import CORS
from models import db, Todo

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///db.sqlite3'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db.init_app(app)
CORS(app)

@app.before_first_request
def create_tables():
    db.create_all()

@app.route('/')
def home():
    return jsonify({"message": "To-Do API is running!"})

@app.route('/todos', methods=['GET'])
def get_todos():
    todos = Todo.query.all()
    return jsonify([todo.serialize() for todo in todos])

@app.route('/todos', methods=['POST'])
def add_todo():
    data = request.get_json()
    task = data.get('task', '')
    if not task:
        return jsonify({"error": "Task is required"}), 400
    new_todo = Todo(task=task)
    db.session.add(new_todo)
    db.session.commit()
    return jsonify(new_todo.serialize()), 201

@app.route('/todos/<int:id>', methods=['PUT'])
def update_todo(id):
    data = request.get_json()
    todo = Todo.query.get_or_404(id)
    todo.done = data.get('done', todo.done)
    db.session.commit()
    return jsonify(todo.serialize())

@app.route('/todos/<int:id>', methods=['DELETE'])
def delete_todo(id):
    todo = Todo.query.get_or_404(id)
    db.session.delete(todo)
    db.session.commit()
    return jsonify({"message": "Deleted"}), 204

if __name__ == '__main__':
    app.run(debug=True)
