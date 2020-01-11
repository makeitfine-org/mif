db.auth('root', 'rootpass');

db.createUser(
    {
      user: "introuser",
      pwd: "intropass",
      roles: [{role: "readWrite", db: "introdb"},
        {role: "read", db: "reporting"}]
    }
);

// Create role for any actions (to execute eval script):
db.createRole({
  role: "executeEval",
  privileges: [{resource: {anyResource: true}, actions: ["anyAction"]}],
  roles: []
})
db.grantRolesToUser("introuser", [{role: "executeEval", db: "admin"}])
