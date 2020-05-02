import { GET_ERRORS } from "../actions/types";

const initialState = {};

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_ERRORS:
            return action.payload; //if we have error from the server, dispatch the payload to the store
        default:
            return state;
    }
}