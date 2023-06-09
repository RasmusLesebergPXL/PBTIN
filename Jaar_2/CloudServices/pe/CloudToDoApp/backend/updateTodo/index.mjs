import { DynamoDBClient, UpdateItemCommand   } from "@aws-sdk/client-dynamodb";
import { marshall, unmarshall } from "@aws-sdk/util-dynamodb"
import  { randomUUID } from "crypto";
/*
Function that handles updating an object in DynamoDB based on the id provided in the url
a parameter in the API route.

Make sure the DYNAMOTABLENAME and region are set correctly.
Make sure the Lambda has the correct execution role(s)
*/
export const handler = async(event) => {
    console.log('Received event:', JSON.stringify(event, null, 2));
    
    const DYNAMODBTABLENAME = 'todo';
    let body;
    let statusCode = '200';
    const headers = {
        'Content-Type': 'application/json',
        "Access-Control-Allow-Headers" : "*",
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "*"
    };
    const client = new DynamoDBClient({ region: 'us-east-1' });
    
    try{
        const item = JSON.parse(event.body);
        if(!item.title || !item.label)
            throw new Error("Missing title or label property");
        if(event.pathParameters && event.pathParameters.id){
            // Todo check if the item exists, if not error
            item._id = event.pathParameters.id;
        }else{
            throw new Error("No id provided");
        }
        const params = {
                TableName: DYNAMODBTABLENAME,
                Key: {
                    _id: {S: item._id},
                },
                UpdateExpression: "set title = :t, label = :l, completed = :c",
                ExpressionAttributeValues: {
                    ":t": {S: item.title},
                    ":l": {S: item.label},
                    ":c": {BOOL: item.completed}
                },
                ReturnValues: "ALL_NEW"
              }
    
        const command = new UpdateItemCommand (params);
        const response = await client.send(command);
        body = unmarshall(response.Attributes);
        
    }catch(err){
        statusCode = '400';
        body = err.message;
    }finally{
        body = JSON.stringify(body);
    }
        
    return {
        statusCode,
        body,
        headers,
    };
};
