import CodeBlock from "@/components/code/code";
import { Box, Typography } from "@mui/material";
import Image from "next/image";
import { ReactElement } from "react";

export default function Page() : ReactElement {
    return(<div>
        <Box>
            <Typography variant="h4">Selection Box and Switches</Typography>

            {/* Selection Box */}
            <div id="selection">
                <Box sx={{ marginBottom: "125px" }}>
                    <Typography variant="h5">Selection Box</Typography>
                    <Box sx={{ display: "flex", width: "fit-content" }}>
                        <Image
                            src={"../clickable/selection/selection.png"}
                            alt="Image of three selection boxes"

                            width={200} height={75} priority

                            style={{ borderRadius: "10px",
                                margin: "auto 5%"
                            }}
                        />
                        <Box sx={{ margin: "auto" }}>
                            <CodeBlock>{
                                'SelectionBox()\n' +
                                'SelectionBox(disabled = true)\n' +
                                'SelectionBox(value = true)\n'
                            }</CodeBlock>
                        </Box>
                    </Box>
                    <Box sx={{ marginTop: "50px" }}>
                        <Typography>
                            A selection box can either be <code>True</code> or <code>False</code> and
                            just like buttons it has an <code>onClick</code> callback that gets called
                            when the selection box is interacted with.
                            <br style={{ marginBottom: "15px" }} />
                            However the component does not provide a <code>boolean state</code> when
                            it is interacted with.
                            <br />
                            Instead create a <code>boolean state</code> for the selection box and
                            update that state on update.
                        </Typography>
                        <Box sx={{ width: "50%" }}>
                            <CodeBlock>{
                                "var state by remember { mutableStateOf(false) }\n\n" +
                                "SelectionBox(state, { state = !state })\n"
                            }</CodeBlock>
                        </Box>
                    </Box>
                </Box>
            </div>

            {/* Switch */}
            <div id="switch">
                <Box>
                    <Typography variant="h5">Switch</Typography>
                    <Box sx={{ display: "flex", width: "fit-content" }}>
                        <Image
                            src={"../clickable/selection/switch.png"}
                            alt="Image of three switches"

                            width={250} height={50} priority

                            style={{ borderRadius: "10px",
                                margin: "auto 5%"
                            }}
                        />
                        <Box sx={{ margin: "auto" }}>
                            <CodeBlock>{
                                'Switch()\n' +
                                'Switch(disabled = true)\n' +
                                'Switch(value = true)\n'
                            }</CodeBlock>
                        </Box>
                    </Box>
                    <Box>
                        <Typography>
                            Just like the <code>Selection Box</code> the Switch does not give
                            its state value when it is clicked in the <code>onClick</code>.
                        </Typography>
                    </Box>
                </Box>
            </div>
        </Box>
    </div>)
}
